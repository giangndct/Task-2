package com.example.Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class CreateData {
    public static void main(String[] args) throws IOException {
        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set("hbase.zookeeper.quorum", "127.0.0.1");
        hbaseConfig.set("hbase.zookeeper.property.clientPort", "2181");

        HTable hTable = new HTable(hbaseConfig, "emp");

        Put p = new Put(Bytes.toBytes("emp4"));


        p.add(Bytes.toBytes("info"),
                Bytes.toBytes("name"),Bytes.toBytes("raju"));

        p.add(Bytes.toBytes("info"),
                Bytes.toBytes("city"),Bytes.toBytes("hyderabad"));

        p.add(Bytes.toBytes("info"),Bytes.toBytes("designation"),
                Bytes.toBytes("manager"));

        p.add(Bytes.toBytes("info"),Bytes.toBytes("salary"),
                Bytes.toBytes("50000"));


        hTable.put(p);
        System.out.println("data inserted");

        hTable.close();
    }
}
