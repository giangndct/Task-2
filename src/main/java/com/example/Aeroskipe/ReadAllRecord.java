package com.example.Aeroskipe;

import com.aerospike.client.*;
import com.aerospike.client.query.Statement;

public class ReadAllRecord {
    public static void main(String[] args) {

        AerospikeClient client = new AerospikeClient("localhost", 3000);
        try {
            Statement stmt = new Statement();
            stmt.setNamespace("test");
            stmt.setSetName("phones");

            client.scanAll(null, stmt.getNamespace(), stmt.getSetName(), new ScanCallback() {
                        @Override
                        public void scanCallback(Key key, Record record) throws AerospikeException {
                            System.out.println("Record found:");
                            System.out.println("Key: " + key.userKey);

                        }
                    }
            );
        } catch (AerospikeException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}
