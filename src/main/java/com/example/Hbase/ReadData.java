package com.example.Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ReadData {
    public static void main(String[] args) throws IOException {
        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set("hbase.zookeeper.quorum", "127.0.0.1");
        hbaseConfig.set("hbase.zookeeper.property.clientPort", "2181");
        HTable table = new HTable(hbaseConfig, "emp");


        Get g = new Get(Bytes.toBytes("emp4"));


        Result result = table.get(g);


        byte [] value = result.getValue(Bytes.toBytes("info"),Bytes.toBytes("name"));

        byte [] value1 = result.getValue(Bytes.toBytes("info"),Bytes.toBytes("city"));


        String name = Bytes.toString(value);
        String city = Bytes.toString(value1);

        System.out.println("name: " + name + " city: " + city);
    }
}
