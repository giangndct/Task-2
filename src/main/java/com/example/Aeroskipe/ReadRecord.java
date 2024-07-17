package com.example.Aeroskipe;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.Policy;

public class ReadRecord {
    public static void main(String[] args) {
        AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);

        Key key = new Key("test", "phones", "phone4");

        Policy policy = new Policy();
        policy.socketTimeout = 300;

        Record record = client.get(policy, key);
        System.out.println(key.userKey);
        System.out.format("Record: %s", record.bins);


        client.close();
    }
}
