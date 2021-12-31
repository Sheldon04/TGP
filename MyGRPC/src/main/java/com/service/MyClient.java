package com.service;

import com.dao.ServiceDAO;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


import org.tensorflow.framework.DataType;
import org.tensorflow.framework.TensorProto;
import org.tensorflow.framework.TensorShapeProto;
import tensorflow.serving.Model;
import tensorflow.serving.Predict;
import tensorflow.serving.PredictionServiceGrpc;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClient {
    private static final Logger logger = Logger.getLogger(MyClient.class.getName());

    private final GetProfileGrpc.GetProfileBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public MyClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
//        blockingStub = GetProfileGrpc.newBlockingStub(channel);
        blockingStub = GetProfileGrpc.newBlockingStub(channel);
    }

    public void getMovieProfile(String id) {
        logger.info("Will try to find " + id + " ...");
        MovieProfileRequest request = MovieProfileRequest.newBuilder().setId(id).build();
        MovieProfileReply response;
        try {
            response = blockingStub.getMovieProfile(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Movie's ID: " + response.getMid());
        logger.info("Movie's title: " + response.getTitle());
        logger.info("Movie's genre: " + response.getGenre());
    }

    public void getUserProfile(String id) {
        logger.info("Will try to find " + id + " ...");
        UserProfileRequest request = UserProfileRequest.newBuilder().setId(id).build();
        UserProfileReply response;
        try {
            response = blockingStub.getUserProfile(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("User's ID: " + response.getUid());
        for (int i=0; i<response.getRatingCount(); i++) {
            logger.info("Rating: " + response.getRating(i));
        }

    }

    public void getRecommend(String id) {
        logger.info("Will try to recommend to " + id + " ...");
        UserRecommendRequest request = UserRecommendRequest.newBuilder().setId(id).build();
        UserRecommendReply response;
        try {
            response = blockingStub.getRecommend(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        for (int i=0; i<10; i++) {
            logger.info("Movie" + i + ": " + response.getMid(i));
        }

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void main(String[] args) throws Exception {
        // String user = "world";
        String uid = "100307";
        // Access a service running on the local machine on port 50051
        String target = "127.0.0.1:50051";
//        // Allow passing in the user and target strings as command line arguments
//        if (args.length > 0) {
//            if ("--help".equals(args[0])) {
//                System.err.println("Usage: [name [target]]");
//                System.err.println("");
//                System.err.println("  name    The name you wish to be greeted by. Defaults to " + mid);
//                System.err.println("  target  The server to connect to. Defaults to " + target);
//                System.exit(1);
//            }
//            mid = args[0];
//        }
//        if (args.length > 1) {
//            target = args[1];
//        }

        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            MyClient client = new MyClient(channel);
//            client.getMovieProfile(mid);
            client.getRecommend(uid);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

//    public static void main(String[] args) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8500).usePlaintext().build();
//        // 使用block模式
//        PredictionServiceGrpc.PredictionServiceBlockingStub stub = PredictionServiceGrpc.newBlockingStub(channel);
//        // 创建请求
//        Predict.PredictRequest.Builder predictRequestBuilder = Predict.PredictRequest.newBuilder();
//        // 模型名称和模型方法名预设
//        Model.ModelSpec.Builder modelSpecBuilder = Model.ModelSpec.newBuilder();
//        modelSpecBuilder.setName("rankmodel");
//        predictRequestBuilder.setModelSpec(modelSpecBuilder);
//
//        ServiceDAO sd = new ServiceDAO();
//        String movie_id ="1";
//        String user_id="2";
//        List<String> inputList = sd.getModelInputs(user_id, movie_id);
//
//        List<Integer> l1 = Collections.singletonList(Integer.parseInt(inputList.get(0)));
//        TensorProto.Builder uratingnum = TensorProto.newBuilder();
//        uratingnum.setDtype(DataType.DT_INT32);
//        uratingnum.addAllIntVal(l1);
//
//        List<Integer> l2 = Collections.singletonList(Integer.parseInt(movie_id));
//        TensorProto.Builder movieid = TensorProto.newBuilder();
//        movieid.setDtype(DataType.DT_INT32);
//        movieid.addAllIntVal(l2);
//
//        List<Integer> l3 = Collections.singletonList(Integer.parseInt(inputList.get(1)));
//        TensorProto.Builder ulikenum = TensorProto.newBuilder();
//        ulikenum.setDtype(DataType.DT_INT32);
//        ulikenum.addAllIntVal(l3);
//
//        List<Integer> l4 = Collections.singletonList(Integer.parseInt(user_id));
//        TensorProto.Builder userid = TensorProto.newBuilder();
//        userid.setDtype(DataType.DT_INT32);
//        userid.addAllIntVal(l4);
//
//        List<Integer> l5 = Collections.singletonList(Integer.parseInt(inputList.get(2)));
//        TensorProto.Builder mlikenum = TensorProto.newBuilder();
//        mlikenum.setDtype(DataType.DT_INT32);
//        mlikenum.addAllIntVal(l5);
//
//        List<Float> l6 = Collections.singletonList(Float.parseFloat(inputList.get(3)));
//        TensorProto.Builder uavgrating = TensorProto.newBuilder();
//        uavgrating.setDtype(DataType.DT_FLOAT);
//        uavgrating.addAllFloatVal(l6);
//
//        List<Integer> l7 = Collections.singletonList(Integer.parseInt(inputList.get(4)));
//        TensorProto.Builder timestamp = TensorProto.newBuilder();
//        timestamp.setDtype(DataType.DT_INT32);
//        timestamp.addAllIntVal(l7);
//
//        predictRequestBuilder.putInputs("uratingnum", uratingnum.build());
//        predictRequestBuilder.putInputs("movieid", movieid.build());
//        predictRequestBuilder.putInputs("ulikenum", ulikenum.build());
//        predictRequestBuilder.putInputs("userid", userid.build());
//        predictRequestBuilder.putInputs("mlikenum", mlikenum.build());
//        predictRequestBuilder.putInputs("timestamp", timestamp.build());
//        predictRequestBuilder.putInputs("uavgrating", uavgrating.build());
//
//        // 访问并获取结果
//        Predict.PredictResponse predictResponse = stub.withDeadlineAfter(3, TimeUnit.SECONDS).predict(predictRequestBuilder.build());
//        Map<String, TensorProto> result = predictResponse.getOutputsMap();
//
//        System.out.println("预测值是:" + result.get("output_1").getFloatVal(0));
//    }
}
