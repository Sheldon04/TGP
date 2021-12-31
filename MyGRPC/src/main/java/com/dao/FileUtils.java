package com.dao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.*;
import java.util.*;

public class FileUtils {

    public static void main(String[] args) {
        find();
        System.out.println("ok");
    }


    public static void writeCSV(){
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;
        String line = "";
        String line2="";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/nosql_raw/genome-scores.csv";

        Set<String> userSet = new HashSet<>();

        String tag_id = "";
        String movie_id = "";
        String relevance = "";

        try {
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/nosql_raw/genome-scores-hbase.csv");

            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append
            line = br.readLine();
            for(int i=0; i < 15584448; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                movie_id = country[0];
                tag_id = country[1];
                relevance = country[2];


                bw.write(movie_id + "-" + tag_id + "," + relevance);
                // add new line
                bw.newLine();
            }
            bw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ranking(){
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;
        String line = "";
        String line2="";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/final/recall.csv";
        String readFile2 = "/Users/sheldon-t/Desktop/nosql/output/predictions.csv";

        Set<String> userSet = new HashSet<>();

        String user_id = "";
        String movie_id = "";
        String score = "";

        try {
            File writeFile = new File("/Users/sheldon-t/Desktop/nosql/final/recommend.csv");
//
//            br = new BufferedReader(new FileReader(readFile));
////            br2 = new BufferedReader(new FileReader(readFile2));
//
//            for(int i=0; i < 11368300; i++) {
//                if( i%100000 == 0) {
//                    System.out.println("calc" + i);
//                }
//                line = br.readLine();
//                // use comma as separator
//                String[] country = line.split(cvsSplitBy);
//                user_id = country[0];
//
//                userSet.add(user_id);
//
//            }
//            br.close();


            br = new BufferedReader(new FileReader(readFile));
            br2 = new BufferedReader(new FileReader(readFile2));


            bw = new BufferedWriter(new FileWriter(writeFile, true)); // append
            line = br.readLine();
            line2 = br2.readLine();
            // use comma as separator
            String[] country = line.split(cvsSplitBy);
            String[] country2 = line2.split(cvsSplitBy);
            user_id = country[0];
            movie_id = country[1];
            score = country2[0];

            for(int i=0; i < 162541; i++) {
                if( i%5000 == 0) {
                    System.out.println(i);
                }

                userSet.add(user_id);
                //将map.entrySet()转换成list
                Map<String, Float> map = new HashMap<String, Float>();
                String tmp = user_id;
                while(userSet.contains(user_id)) {
                    if(map.containsKey(movie_id) && map.get(movie_id) < Float.parseFloat(score)) {
                        map.put(movie_id, Float.parseFloat(score));
                    }else if(!map.containsKey(movie_id)) {
                        map.put(movie_id, Float.parseFloat(score));
                    }
                    line = br.readLine();
                    line2 = br2.readLine();

                    if(line == null || line2==null) {
                        break;
                    }
                    String[] country11 = line.split(cvsSplitBy);
                    String[] country22 = line2.split(cvsSplitBy);
                    user_id = country11[0];
                    movie_id = country11[1];
                    score = country22[0];
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

                for(int j=0; j<10; j++) {
                    bw.write(tmp + "," + list.get(j).getKey() + "," + list.get(j).getValue());
                    bw.newLine();
                }
            }
            bw.close();
            br.close();
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//2 5952
    public static void find() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String readFile = "/Users/sheldon-t/Desktop/nosql/test/ratings-test.csv";


        String user_id = "";
        String movie_id = "";
        String flag = "";

        try {
            br = new BufferedReader(new FileReader(readFile));
            for(int i=0; i < 5000096; i++) {
                if( i%100000 == 0) {
                    System.out.println(i);
                }
                line = br.readLine();
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                user_id = country[0];
                movie_id = country[1];
                if("4".equals(user_id) && "109487".equals(movie_id)) {
                    flag = "ai";
                }
            }
            System.out.println(flag);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
