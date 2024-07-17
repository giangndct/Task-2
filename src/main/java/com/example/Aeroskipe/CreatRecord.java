package com.example.Aeroskipe;

import com.aerospike.client.*;
import com.aerospike.client.policy.WritePolicy;

public class CreatRecord {

    public static void CreatRecordExperyTime(String namespaces,String set,String keyvalue,String name,String author){
        AerospikeClient client = new AerospikeClient("localhost", 3000);

        try {
            WritePolicy writePolicy = new WritePolicy();
            writePolicy.sendKey = true;
            int expireInSeconds = 30;
            writePolicy.expiration = expireInSeconds;
            Key key = new Key(namespaces, set, keyvalue);
            Bin bin2 = new Bin("Name", name);
            Bin bin3 = new Bin("author", author);

            client.put(writePolicy, key, bin2,bin3);
            System.out.println("Data written successfully");

        } catch (AerospikeException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            client.close();
        }
    }

    public static void CreatRecordForever(String namespaces,String set,String keyvalue,String name,String author){
        AerospikeClient client = new AerospikeClient("localhost", 3000);

        try {
            WritePolicy writePolicy = new WritePolicy();
            writePolicy.sendKey = true;
            Key key = new Key(namespaces, set, keyvalue);
            Bin bin2 = new Bin("Name", name);
            Bin bin3 = new Bin("author", author);

            client.put(writePolicy, key, bin2,bin3);
            System.out.println("Data written successfully");

        } catch (AerospikeException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            client.close();
        }
    }

    public static void main(String[] args) {
        String namespaces="test";
        String set="phones";
        String keyvalue="phone5";
        String Name="SamSung GalaXY";
        String author="SamSung";

        CreatRecordExperyTime(namespaces,set,keyvalue,Name,author);
    }


}