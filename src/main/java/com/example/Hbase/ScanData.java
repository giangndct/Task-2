package com.example.Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ScanData {
    public static void main(String[] args) throws IOException {
        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set("hbase.zookeeper.quorum", "127.0.0.1");
        hbaseConfig.set("hbase.zookeeper.property.clientPort", "2181");

        HTable table = new HTable(hbaseConfig, "emp");


        Scan scan = new Scan();


        scan.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));

        ResultScanner scanner = table.getScanner(scan);

        for (Result result = scanner.next(); result != null; result = scanner.next())

            System.out.println("Found row : " + result);

        scanner.close();
    }
}
