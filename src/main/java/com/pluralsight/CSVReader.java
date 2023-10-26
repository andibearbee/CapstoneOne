package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;


public class CSVReader {
    public static HashMap<String, Transactions> transLedger = new HashMap<>();
    public static void readTransactions() {
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String csv;

            //read csv file but skip title line
            while ((csv = bufRead.readLine()) != null) {//write an addition to condition to not read a space

                String[] transactionList = csv.split("\\|");

                if (!transactionList[0].contains("date")) {
                    LocalDate date = LocalDate.parse(transactionList[0]);
                    String time = transactionList[1];
                    String description = transactionList[2];
                    String vendor = transactionList[3];
                    float amount = Float.parseFloat(transactionList[4]);

                    transLedger.put(date.toString() + time, new Transactions(date, time, description, vendor, amount));
                }
            }
            //Close the file outside the loop
            bufRead.close();
            //bounce back to home screen to display welcome message and switch menu
        }
        catch (IOException error){
            error.printStackTrace();
        }
    }
}
