package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Ledger {
    public static HashMap<String, Transactions> transLedger = new HashMap<String, Transactions>();
    public static void readTransactions() {
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String csv;
            //read csv file but skip title line
            while ((csv = bufRead.readLine()) != null) {
                String[] transactionList = csv.split("\\|");
                if (!transactionList[0].contains("date")) {
                    String date = transactionList[0];
                    String time = transactionList[1];
                    String description = transactionList[2];
                    String vendor = transactionList[3];
                    float price = Float.parseFloat(transactionList[4]);

                    transLedger.put(date + time, new Transactions(date, time, description, vendor, price));
                }
            }
            //Close the file outside the loop
            bufRead.close();
        }
        catch (IOException error){
            error.printStackTrace();
        }
    }
}
// readTransactions();
//               for (String hashKey : transLedger.keySet()) {
//                     System.out.println(transLedger.get(hashKey).getDate() + transLedger.get(hashKey).getTime() + transLedger.get(hashKey));
