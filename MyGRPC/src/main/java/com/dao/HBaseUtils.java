package com.dao;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;



public class HBaseUtils {

    public static void main(String[] args) throws IOException {
        Float relevance = getGenome(getConnection(), "50413", "4499");
    }

    public static Float getGenome(Connection connect, String user_id, String tag_id) throws IOException {
        Table table = connect.getTable(TableName.valueOf("genome"));
        Get g = new Get(Bytes.toBytes(user_id+"-"+tag_id));
        g.addColumn("scores".getBytes(), "relevance".getBytes());
        Result result= table.get(g);
        connect.close();

        return Bytes.toFloat(result.getValue("scores".getBytes(), "relevance".getBytes()));
    }

    public static Connection getConnection() throws IOException {
        Configuration config = HBaseConfiguration.create();

        config.set("hbase.zookeeper.quorum","127.0.0.1");
        config.set("hbase.zookeeper.property.clientPort","2181");

        System.out.println("开始连接hbase");
        Connection connect = ConnectionFactory.createConnection(config);
        System.out.println(connect.isClosed());
        Admin admin = connect.getAdmin();
        System.out.println("连接成功");

        return connect;
    }
}
