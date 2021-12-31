package com.dao;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import tensorflow.serving.Model;
import tensorflow.serving.Predict;
import tensorflow.serving.PredictionServiceGrpc;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import static org.neo4j.driver.Values.parameters;


public class Neo4jUtils {

    public static void main(String[] args) throws IOException {
        getUserMovies("uid1");
    }

    public static void getUserMovies(String userId) throws IOException {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8500).usePlaintext().build();
//        // 这里使用block模式
//        PredictionServiceGrpc.PredictionServiceBlockingStub stub = PredictionServiceGrpc.newBlockingStub(channel);
//        // 创建请求
//        Predict.PredictRequest.Builder predictRequestBuilder = Predict.PredictRequest.newBuilder();
//        // 模型名称和模型方法名预设
//        Model.ModelSpec.Builder modelSpecBuilder = Model.ModelSpec.newBuilder();
//        modelSpecBuilder.setName("rankmodel");
//        predictRequestBuilder.setModelSpec(modelSpecBuilder);


        File writeFile = new File("/Users/sheldon-t/Desktop/nosql/final/recall.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile, true)); // append
        org.neo4j.driver.Driver driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "sheldon1204" ) );
        Session session = driver.session();
        int count = 0;

        List<String> users = new ArrayList<>();
//        Result result = session.run( "MATCH (u:User {userId: $userId})-[r]->(m:Movie) RETURN u,m",
//                parameters( "userId", userId) );
        Result result = session.run( "MATCH (u:User) RETURN u");
        while (result.hasNext() )
        {
            String tmp = result.next().get(0).get("userId").asString();
            users.add(tmp.replace("uid", ""));
        }

        for(String user:users){
            count++;
            if(count % 1000 == 0) {
                System.out.println(count);
            }
            Result result1 = session.run( "MATCH (u:User {userId: $userId})-[r]->(m:Movie) RETURN m",
                parameters( "userId", "uid"+user) );
            while (result1.hasNext() )
            {
                bw.write(user + "," + result1.next().get(0).get("movieId").asString().replace("mid", ""));
                // add new line
                bw.newLine();
            }
        }

        bw.close();

        driver.close();

//        for(String s:movies) {
//            System.out.println(s);
//        }
    }

    public static void writeUser(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/nosql_raw/ratings.csv";

        HashSet<String> userSet = new HashSet<>();
        String user_id = "";
        String label = "User";

        try {
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/neo/users.csv");

            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append

            bw.write("userId:ID" + "," + ":LABEL");
            bw.newLine();

            br.readLine();
            for(int i=0; i < 25000094; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = "uid"+country[0];

                if(!userSet.contains(user_id)) {
                    userSet.add(user_id);
                    bw.write(user_id + "," + "User");
                    bw.newLine();
                }
            }

            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeMovie(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/nosql_raw/movies.csv";

        String movie_id = "";
        String label = "Movie";

        try {
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/neo/movies.csv");

            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append

            bw.write("movieId:ID" + "," + ":LABEL");
            bw.newLine();
            br.readLine();
            for(int i=0; i < 62423; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                movie_id = "mid"+country[0];

                bw.write( movie_id+ "," + "Movie");
                bw.newLine();
            }

            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeR(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/recall/result_deepFM.csv";

        String movie_id = "";
        String user_id = "";
        String label = "deepFM";

        try {
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/neo/deepFM.csv");

            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append

            bw.write(":START_ID" + "," + ":END_ID" + "," + ":TYPE");
            bw.newLine();
            for(int i=0; i < 1625410; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = "uid" + country[0];
                movie_id = "mid" + country[1];

                bw.write( user_id+ "," +movie_id + "," + label);
                if(i != 1625409) {
                    bw.newLine();
                }
            }

            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
