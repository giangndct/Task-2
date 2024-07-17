package com.example.Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String... args) throws Exception {
        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set("hbase.zookeeper.quorum", "127.0.0.1");
        hbaseConfig.set("hbase.zookeeper.property.clientPort", "2181");


        try (Connection connection = ConnectionFactory.createConnection(hbaseConfig)) {
            Admin admin = connection.getAdmin();

            TableName tableName = TableName.valueOf("emp");
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
            HColumnDescriptor columnFamily = new HColumnDescriptor("info");

            tableDescriptor.addFamily(columnFamily);
            if(!admin.tableExists(tableName)){
                admin.createTable(tableDescriptor);
            }


            boolean isEnabled = admin.isTableEnabled(tableName);
            System.out.println("Table creation status: " + (isEnabled ? "SUCCESS" : "FAILED"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}