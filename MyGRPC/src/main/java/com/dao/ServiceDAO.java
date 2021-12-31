package com.dao;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.tensorflow.framework.DataType;
import org.tensorflow.framework.TensorProto;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import tensorflow.serving.Model;
import tensorflow.serving.Predict;
import tensorflow.serving.PredictionServiceGrpc;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ServiceDAO {
    private final Jedis jedis;

    public ServiceDAO() {
        jedis = new Jedis("127.0.0.1");
    }

    public Set<Tuple> getUserProfile (String userId) {
        Set<Tuple> result = null;
        Set<String> re = null;
        try {
            re = jedis.zrangeByScore(userId, 0, 5);
            result = jedis.zrangeByScoreWithScores(userId, 0, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(re);
        for (Tuple tuple:result) {
            System.out.println(tuple.getElement() + " " + tuple.getScore());
        }
        return result;
    }

    public Set<String> getRecommend (String userId) {
        Set<String> result = null;
        try {
            result = jedis.smembers("recommend-" + userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<String, String> getMovieProfile (String movieId) {
        Map<String, String> result = null;
        String pattern = movieId;
        try {
            result = jedis.hgetAll(pattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
    //        map.put("uratingnum", list1);
//        map.put("movieid", list2);
//        map.put("ulikenum", list3);
//        map.put("userid", list4);
//        map.put("mlikenum", list5);
//        map.put("uavgrating", list6);
//        map.put("timestamp", list7);



    public List<String> getModelInputs(String uid, String mid) {
        List<String> list = new ArrayList<>();

        String user_id = "";
        String movie_id = "";
        String tag_user_id = "";
        String user_rating_num = ""; //number of ratings that this user has
        String movie_like_num = ""; //number of users that give 5 on this movie
        String user_like_num = "";  //number of movies that this user give 5 star to
        String user_avg_rating = "";//average of ratings score of this user
        String user_tag = ""; //tags that this user give to this movie
        String genome = "";
        String rating = "";
        String time_stamp = "";
        String label = ""; //1 for 5 start, 0 for others

        user_id = "uid-" + uid;
        movie_id = "mid-" + mid;

        user_rating_num = Long.toString(jedis.zcard(user_id));
        user_like_num = Long.toString(jedis.zcount(user_id, 5,5));
        Float total_score = Float.parseFloat(jedis.hget("profile-uid-" + uid, "totalScore"));
        movie_like_num = jedis.hget(movie_id, "likes");
        user_avg_rating = Float.toString(total_score/jedis.zcard(user_id));
        rating = mid;
        time_stamp = "9999999";
        label = "5.0".equals(rating) ? "1" : "0";
        genome = jedis.hget(movie_id, "genome");
        if(genome == null) {
            genome = "0";
        }

        list.add(user_rating_num);
        list.add(user_like_num);
        list.add(movie_like_num);
        list.add(user_avg_rating);
        list.add(time_stamp);

        return list;
    }

    public static List<Float> getPrediction(Predict.PredictRequest.Builder predictRequestBuilder, PredictionServiceGrpc.PredictionServiceBlockingStub stub,
                                            List<Integer> l1,List<Integer> l2,List<Integer> l3,List<Integer> l4,List<Integer> l5,
                                            List<Float> l6, List<Integer> l7) {

        TensorProto.Builder uratingnum = TensorProto.newBuilder();
        uratingnum.setDtype(DataType.DT_INT32);
        uratingnum.addAllIntVal(l1);

        TensorProto.Builder movieid = TensorProto.newBuilder();
        movieid.setDtype(DataType.DT_INT32);
        movieid.addAllIntVal(l2);

        TensorProto.Builder ulikenum = TensorProto.newBuilder();
        ulikenum.setDtype(DataType.DT_INT32);
        ulikenum.addAllIntVal(l3);

        TensorProto.Builder userid = TensorProto.newBuilder();
        userid.setDtype(DataType.DT_INT32);
        userid.addAllIntVal(l4);


        TensorProto.Builder mlikenum = TensorProto.newBuilder();
        mlikenum.setDtype(DataType.DT_INT32);
        mlikenum.addAllIntVal(l5);

        TensorProto.Builder uavgrating = TensorProto.newBuilder();
        uavgrating.setDtype(DataType.DT_FLOAT);
        uavgrating.addAllFloatVal(l6);

        TensorProto.Builder timestamp = TensorProto.newBuilder();
        timestamp.setDtype(DataType.DT_INT32);
        timestamp.addAllIntVal(l7);

        predictRequestBuilder.putInputs("uratingnum", uratingnum.build());
        predictRequestBuilder.putInputs("movieid", movieid.build());
        predictRequestBuilder.putInputs("ulikenum", ulikenum.build());
        predictRequestBuilder.putInputs("userid", userid.build());
        predictRequestBuilder.putInputs("mlikenum", mlikenum.build());
        predictRequestBuilder.putInputs("timestamp", timestamp.build());
        predictRequestBuilder.putInputs("uavgrating", uavgrating.build());

        // 访问并获取结果
        Predict.PredictResponse predictResponse = stub.withDeadlineAfter(3, TimeUnit.SECONDS).predict(predictRequestBuilder.build());
        Map<String, TensorProto> result = predictResponse.getOutputsMap();
        // CRF模型结果，发射矩阵和概率矩阵
        System.out.println("预测值是:" + result.toString());

        System.out.println("my:" + result.get("output_1").getFloatVal(0));

        return new ArrayList<Float>();
    }


}
