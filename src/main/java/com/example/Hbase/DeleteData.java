package com.example.Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class DeleteData {
    public static void main(String[] args) throws IOException {

        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set("hbase.zookeeper.quorum", "127.0.0.1");
        hbaseConfig.set("hbase.zookeeper.property.clientPort", "2181");

        HTable table = new HTable(hbaseConfig, "emp");


        Delete delete = new Delete(Bytes.toBytes("emp4"));
        delete.deleteColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
        Delete delete1= new Delete(Bytes.toBytes("emp1"));
        delete1.deleteFamily(Bytes.toBytes("info"));


        table.delete(delete);
        System.out.println("data deleted emp4");
        table.delete(delete1);
        System.out.println("data deleted emp1");
        // closing the HTable object
        table.close();

    }
}
