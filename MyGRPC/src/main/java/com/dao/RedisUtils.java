package com.dao;

import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.*;
import java.util.*;

public class RedisUtils {

    public static void main(String[] args) throws IOException {

        Jedis jedis = new Jedis("127.0.0.1");
//        jedis.auth("666666");
        System.out.println("ok");
        writeCSV(jedis);
//        System.out.println(jedis.smembers("recommend-1"));
        jedis.close();
    }

    private static void usePipelineRatings(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/train/ratings-train.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;

        try {
            Pipeline pl = jedis.pipelined();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String key = "uid-" + country[0];
                float score = Float.parseFloat(country[2]);
                String value = country[1] + "-" + country[3];
                pl.zadd(key, score, value);
            }
            pl.sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void usePipelineMovies(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/train/movies.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String cvsSplitBy1 = ",\"";
        String cvsSplitBy2 = "\",";

        String title = "title";
        String genre = "genre";
        String tt = "";
        String gn="";

        try {
            Pipeline pl = jedis.pipelined();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                tt = country[1];
                gn = country[2];
                if (country.length > 3) {
                   String[] tmp = line.split(cvsSplitBy1);
                   tt = line.split(cvsSplitBy1)[1].split(cvsSplitBy2)[0];
                   gn = line.split(cvsSplitBy1)[1].split(cvsSplitBy2)[1];
                }
                String key = "mid-" + country[0];
                if ("mid-102275".equals(key)) {
                    for (int i = 1; i < country.length; i++) {
                        System.out.println(country[i]);
                    }
                }
                Map<String, String> map = new HashMap<>();
                map.put(title, tt);
                map.put(genre, gn);
                pl.hmset(key, map);
            }
            pl.sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void usePipelineTags(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/train/tags-train.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            Pipeline pl = jedis.pipelined();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String key = "tag-uid-" + country[0];
                float score = Integer.parseInt(country[1]);
                String value = country[2];

                pl.zadd(key, score, value);
            }
            pl.sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void usePipelineRecommend(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/final/recommend.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            Pipeline pl = jedis.pipelined();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String key = "recommend-" + country[0];
                String value = country[1];

                pl.sadd(key, value);
            }
            pl.sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void usePipelineDel(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/train/tags-train.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            Pipeline pl = jedis.pipelined();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String key = "tag-uid-" + country[0];

                pl.del(key);
            }
            pl.sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void initMovieLikes(Jedis jedis){
        Set<String> keySet = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        map.put("likes", "0");
        try {
            Pipeline pl = jedis.pipelined();
            keySet = jedis.keys("mid*");
            for(String key: keySet) {
                pl.hmset(key, map);
            }
            pl.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setMovieLikes(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/train/ratings-train.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            Pipeline pl = jedis.pipelined();

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String mid = "mid-" + country[1];
                if("5.0".equals(country[2])) {
                    pl.hincrBy(mid, "likes", 1);
                }
            }
            pl.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMovieTag(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/nosql_raw/genome-scores.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<String, Float> map = new HashMap<String, Float>();


        try {
            Pipeline pl = jedis.pipelined();

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

                for(int i=0; i<998; i++) {
//                    line = br.readLine();
                    String[] country = line.split(cvsSplitBy);
                    String mid = "mid-" + country[0];
                    String tag = country[1];
                    Float score = Float.parseFloat(country[2]);
                    map.put(tag, score);
                    if(i != 997) {
                        line = br.readLine();
                    }
                }

                List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(map.entrySet());
                list.sort(new Comparator<Map.Entry<String, Float>>() {
                    //降序排序
                    @Override
                    public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                        //return o1.getValue().compareTo(o2.getValue());
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
//                System.out.println("-------------------");
//                System.out.println(line);
//                System.out.println(list.get(0).getKey());

                String[] country = line.split(cvsSplitBy);
                String key = "mid-" + country[0];
                Map<String, String> map2 = new HashMap<>();
                map2.put("genome", list.get(0).getKey());
                pl.hmset(key, map2);
            }
            pl.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setUserProfile(Jedis jedis) {
        String csvFile = "/Users/sheldon-t/Desktop/nosql/train/ratings-train.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            Pipeline pl = jedis.pipelined();

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String uid = "profile-uid-" + country[0];
                pl.hincrByFloat(uid, "totalScore", Float.parseFloat(country[2]));
            }
            pl.sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV(Jedis jedis) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/test/ratings-test.csv";

        final String USER_ID = "userid";
        final String MOVIE_ID = "movieid";
        final String USER_RATING_NUM = "uratingnum"; //number of ratings that this user has
        final String MOVIE_LIKE_NUM = "mlikenum"; //number of users that give 5 on this movie
        final String USER_LIKE_NUM = "ulikenum";  //number of movies that this user give 5 star to
        final String USER_TAG = "utag"; //tags that this user give to this movie
        final String USER_AVG_RATING = "uavgrating";
        final String RATING = "rating";
        final String TIME_STAMP = "timestamp";
        final String LABEL = "label"; //1 for 5 start, 0 for others


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

        Float total_score;


        try {
            Pipeline pl = jedis.pipelined();
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/concat/ratings-test-concat.csv");

            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append
            bw.write(USER_ID + "," + MOVIE_ID + "," + USER_RATING_NUM + "," + MOVIE_LIKE_NUM + "," +
                    USER_LIKE_NUM + "," + USER_AVG_RATING  + "," + TIME_STAMP + "," + LABEL);
            bw.newLine();
            // 3199953
            for(int i=0; i < 5000096; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = "uid-" + country[0];
                movie_id = "mid-" + country[1];

                user_rating_num = Long.toString(jedis.zcard(user_id));
                user_like_num = Long.toString(jedis.zcount(user_id, 5,5));
                total_score = Float.parseFloat(jedis.hget("profile-uid-" + country[0], "totalScore"));
                movie_like_num = jedis.hget(movie_id, "likes");
                user_avg_rating = Float.toString(total_score/jedis.zcard(user_id));
                rating = country[2];
                time_stamp = country[3];
                label = "5.0".equals(rating) ? "1" : "0";

                bw.write(country[0] + "," + country[1] + "," + user_rating_num + "," + movie_like_num + "," +
                        user_like_num + "," + user_avg_rating + "," + time_stamp + "," + label);
                // add new line
                bw.newLine();


                user_id = "";
                movie_id = "";
                tag_user_id = "";
                user_rating_num = ""; //number of ratings that this user has
                movie_like_num = ""; //number of users that give 5 on this movie
                user_like_num = "";  //number of movies that this user give 5 star to
                user_tag = ""; //tags that this user give to this movie
                rating = "";
                time_stamp = "";
                label = ""; //1 for 5 start, 0 for others
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCSVFinal(Jedis jedis){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/final/recall.csv";

        final String USER_ID = "userId";
        final String MOVIE_ID = "movieId";
        final String USER_RATING_NUM = "uRatingNum"; //number of ratings that this user has
        final String MOVIE_LIKE_NUM = "mLikeNum"; //number of users that give 5 on this movie
        final String USER_LIKE_NUM = "uLikeNum";  //number of movies that this user give 5 star to
        final String USER_TAG = "uTag"; //tags that this user give to this movie
        final String USER_AVG_RATING = "uAvgRating";
        final String RATING = "rating";
        final String TIME_STAMP = "timestamp";
        final String LABEL = "label"; //1 for 5 start, 0 for others


        String user_id = "";
        String movie_id = "";
        String tag_user_id = "";
        String user_rating_num = ""; //number of ratings that this user has
        String movie_like_num = ""; //number of users that give 5 on this movie
        String user_like_num = "";  //number of movies that this user give 5 star to
        String user_avg_rating = "";//average of ratings score of this user
        String user_tag = ""; //tags that this user give to this movie
        String rating = "";
        String time_stamp = "";
        String label = ""; //1 for 5 start, 0 for others

        Float total_score;


        try {
            Pipeline pl = jedis.pipelined();
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/final/concat.csv");

            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append
            bw.write(USER_ID + "," + MOVIE_ID + "," + USER_RATING_NUM + "," + MOVIE_LIKE_NUM + "," +
                    USER_LIKE_NUM + "," + USER_AVG_RATING + "," + TIME_STAMP + "," + LABEL);
            bw.newLine();
            // 3199953
            for(int i=0; i < 11368300; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = "uid-" + country[0];
                movie_id = "mid-" + country[1];

                user_rating_num = Long.toString(jedis.zcard(user_id));
                user_like_num = Long.toString(jedis.zcount(user_id, 5,5));
                total_score = Float.parseFloat(jedis.hget("profile-uid-" + country[0], "totalScore"));
                movie_like_num = jedis.hget(movie_id, "likes");
                user_avg_rating = Float.toString(total_score/jedis.zcard(user_id));
                rating = "5.0";
                time_stamp = "9999999";
                label = "5.0".equals(rating) ? "1" : "0";

                bw.write(country[0] + "," + country[1] + "," + user_rating_num + "," + movie_like_num + "," +
                        user_like_num + "," + user_avg_rating + "," + time_stamp + "," + label);
                // add new line
                bw.newLine();


                user_id = "";
                movie_id = "";
                tag_user_id = "";
                user_rating_num = ""; //number of ratings that this user has
                movie_like_num = ""; //number of users that give 5 on this movie
                user_like_num = "";  //number of movies that this user give 5 star to
                user_tag = ""; //tags that this user give to this movie
                rating = "";
                time_stamp = "";
                label = ""; //1 for 5 start, 0 for others
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV2(Jedis jedis){
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;
        String line = "";
        String line2="";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/train/ratings-train.csv";
        String readFile2 = "/Users/sheldon-t/Desktop/nosql/concat/ratings-train-concat.csv";

        Set<String> userSet = new HashSet<>();

        String user_id = "";
        String movie_id = "";
        String rating = "";
        int mLikeNum;
        int uLikeNum;

        try {
            Pipeline pl = jedis.pipelined();
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/concat/ratings-new-concat-4.csv");

            br = new BufferedReader(new FileReader(readFile));
            br2 = new BufferedReader(new FileReader(readFile2));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append
            line2 = br2.readLine();
            for(int i=0; i < 16000000; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                line2 = br2.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String[] country2 = line2.split(cvsSplitBy);
                user_id = country[0];
                movie_id = country[1];
                if("null".equals(country2[3])) {
                    mLikeNum = 0;
                }else {
                    mLikeNum = Integer.parseInt(country2[3]);
                }
                rating = country[2];

                if(mLikeNum >= 10) {
                    userSet.add(user_id);
                    bw.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw.newLine();
                }
            }
            br.close();
            br.close();
            br = new BufferedReader(new FileReader(readFile));
            for(int j=0; j < 16000000; j++) {
                if( j%1000000 == 0) {
                    System.out.println("new" + j);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = country[0];
                movie_id = country[1];
                rating = country[2];

                if(!userSet.contains(user_id)) {
                    userSet.add(user_id);
                    bw.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw.newLine();
                }
            }

            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV3(Jedis jedis){
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;
        BufferedWriter bw3 = null;
        BufferedWriter bw4 = null;
        BufferedWriter bw5 = null;
        BufferedWriter bw6 = null;
        BufferedWriter bw7 = null;

        String line = "";
        String line2="";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/concat/ratings-train-concat.csv";
        String readFile2 = "/Users/sheldon-t/Desktop/nosql/train/ratings-train.csv";


        String user_id = "";
        String movie_id = "";
        String rating = "";
        int mLikeNum;
        int uLikeNum;


        try {
            Pipeline pl = jedis.pipelined();
            File writeFile1 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-1.csv");
            File writeFile2 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-2.csv");
            File writeFile3 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-3.csv");
            File writeFile4 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-4.csv");
            File writeFile5 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-5.csv");
            File writeFile6 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-6.csv");
            File writeFile7 = new File("/Users/sheldon-t/Desktop/nosql/usercf/ratings-ucf-concat-7.csv");

            br = new BufferedReader(new FileReader(readFile));
            br2 = new BufferedReader(new FileReader(readFile2));
            bw1 = new BufferedWriter(new FileWriter(writeFile1, true)); // append
            bw2 = new BufferedWriter(new FileWriter(writeFile2, true)); // append
            bw3 = new BufferedWriter(new FileWriter(writeFile3, true)); // append
            bw4 = new BufferedWriter(new FileWriter(writeFile4, true)); // append
            bw5 = new BufferedWriter(new FileWriter(writeFile5, true)); // append
            bw6 = new BufferedWriter(new FileWriter(writeFile6, true)); // append
            bw7 = new BufferedWriter(new FileWriter(writeFile7, true)); // append

            br.readLine();
            for(int i=0; i < 16000000; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                try {
                    line = br.readLine();
                    line2 = br2.readLine();
                }catch (Exception e) {
                    continue;
                }
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                String[] country2 = line2.split(cvsSplitBy);
                user_id = country[0];
                movie_id = country[1];
                rating = country2[2];
                if("null".equals(country[4])) {
                    uLikeNum = 0;
                } else {
                    uLikeNum = Integer.parseInt(country[4]);
                }


                if(uLikeNum < 3) {
                    bw1.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw1.newLine();
                } else if(uLikeNum < 6) {
                    bw2.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw2.newLine();
                }
                else if(uLikeNum < 10) {
                    bw3.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw3.newLine();
                }
                else if(uLikeNum < 15) {
                    bw4.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw4.newLine();
                }
                else if(uLikeNum < 23) {
                    bw5.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw5.newLine();
                }
                else if(uLikeNum < 40) {
                    bw6.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw6.newLine();
                }
                else{
                    bw7.write(country[0] + "," + country[1] + "," + rating);
                    // add new line
                    bw7.newLine();
                }
            }

            bw1.close();
            bw2.close();
            bw3.close();
            bw4.close();
            bw5.close();
            bw6.close();
            bw7.close();
            br.close();
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void countCSV(Jedis jedis){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/final/recall.csv";

        Set<String> mset = new HashSet<>();
        Set<String> uset = new HashSet<>();

        String user_id = "";
        String movie_id = "";
        String rating = "";
        int mLikeNum;
        int uLikeNum;


        try {

            br = new BufferedReader(new FileReader(readFile));
            //10082204
            for(int i=0; i < 11368300; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = country[0];
                movie_id = country[1];

                mset.add(movie_id);
                uset.add(user_id);
            }
            br.close();
            System.out.println("Movie: " + mset.size());
            System.out.println("User: " + uset.size());

            //1262
            //130038

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void countMovieLike(Jedis jedis){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/concat/ratings-train-concat.csv";

        Set<String> userSet = new HashSet<>();
        // 0-100
        Set<String> set1 = new HashSet<>();
        //100-200
        Set<String> set2 = new HashSet<>();
        //200-500
        Set<String> set3 = new HashSet<>();
        //500-1000
        Set<String> set4 = new HashSet<>();
        //1000-
        Set<String> set5 = new HashSet<>();
        Set<String> set6 = new HashSet<>();
        Set<String> set7 = new HashSet<>();

        String user_id = "";
        String movie_id = "";
        int mLikeNum;
        int uLikeNum;


        try {

            br = new BufferedReader(new FileReader(readFile));
            line = br.readLine();
            for(int i=0; i < 16000000; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if("null".equals(country[4])) {
                    uLikeNum = 0;
                } else {
                    uLikeNum = Integer.parseInt(country[4]);
                }
                user_id = country[0];
                movie_id = country[1];

                userSet.add(user_id);
                if(uLikeNum < 3) {
                    set1.add(user_id);
                }else if(uLikeNum < 6) {
                    set2.add(user_id);
                }else if(uLikeNum < 10) {
                    set3.add(user_id);
                }
                else if(uLikeNum < 15) {
                    set4.add(user_id);
                }
                else if(uLikeNum < 23) {
                    set5.add(user_id);
                }
                else if(uLikeNum < 40) {
                    set6.add(user_id);
                }
                else {
                    set7.add(user_id);
                }

            }
            br.close();
            System.out.println("Movie1: " + set1.size());
            System.out.println("Movie2: " + set2.size());
            System.out.println("Movie3: " + set3.size());
            System.out.println("Movie4: " + set4.size());
            System.out.println("Movie5: " + set5.size());
            System.out.println("Movie6: " + set6.size());
            System.out.println("Movie7: " + set7.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
