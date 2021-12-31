
package com.service;

import com.dao.ServiceDAO;
import io.grpc.BindableService;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import redis.clients.jedis.Tuple;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MyServer {
    private static final Logger logger = Logger.getLogger(MyServer.class.getName());
    private io.grpc.Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService((BindableService) new GetProfileImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    MyServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final MyServer server = new MyServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    static class GetProfileImpl extends GetProfileGrpc.GetProfileImplBase {
        @Override
        public void getUserProfile(UserProfileRequest request, StreamObserver<UserProfileReply> responseObserver) {
            ServiceDAO serviceDAO = new ServiceDAO();
            Set<Tuple> set = serviceDAO.getUserProfile(request.getId());
            UserProfileReply.Builder builder = UserProfileReply.newBuilder();
            builder.setUid(request.getId());
            for (Tuple tuple: set) {
                UserProfileReply.Rating.Builder builder1 = UserProfileReply.Rating.newBuilder();
                builder1.setMid(tuple.getElement());
                builder1.setRating((float) tuple.getScore());
                builder.addRating(builder1.build());
            }
            UserProfileReply reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void getMovieProfile(MovieProfileRequest request, StreamObserver<MovieProfileReply> responseObserver) {
            ServiceDAO serviceDAO = new ServiceDAO();
            Map<String, String> map = serviceDAO.getMovieProfile(request.getId());
            MovieProfileReply.Builder builder = MovieProfileReply.newBuilder();
            builder.setMid(request.getId());

            builder.setTitle(map.get("title"));
            builder.setGenre(map.get("genre"));
            MovieProfileReply reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void getRecommend(UserRecommendRequest request, StreamObserver<UserRecommendReply> responseObserver) {
            ServiceDAO serviceDAO = new ServiceDAO();
            Set<String> set = serviceDAO.getRecommend(request.getId());
            UserRecommendReply.Builder builder = UserRecommendReply.newBuilder();
            builder.addAllMid(set);
            UserRecommendReply reply = builder.build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}