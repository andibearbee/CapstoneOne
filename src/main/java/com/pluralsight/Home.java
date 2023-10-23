package com.pluralsight;
import java.io.*;
import java.util.*;
import java.time.*;
public class Home {
    public static Scanner  scanner = new Scanner(System.in);
    public static HashMap<String, Transactions> transLedger = new HashMap<String, Transactions>();
    public static void main(String[] args) {
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("Welcome to your Transaction History! What would you like to do?" + "\n" + "Choose from the options below: " + "\n" + "1: Add Deposit Information" +"\n" + "2: Add Payment Information" + "\n" + "3: Read Transaction History" + "\n" + "4: Exit");

            int userChoice = scanner.nextInt();
             switch (userChoice) {
                 case 1: //write deposit info to csv file
                     System.out.println("Enter your Deposit information: date(YYYY-MM-DD)|time|description|vendor|amount");
                     String userTransInfo = scanner.nextLine();
                    break;
                case 2: //write payment info to csv file
                    break;
                 //read entire ledger (shows transaction history)
                case 3: readLedger();
                    break;
                case 4: //exits application
                    break;
             }
        }


    }
    public static void writeTransactions () {
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv"));

        }
        catch (IOException error) {
            error.printStackTrace();
        }



    }

    public static void readLedger() {
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String csv;
            while ((csv = bufRead.readLine()) != null) {
                String[] Inventory = csv.split("\\|");
                if (!Inventory[0].contains("date")) {
                    String date = Inventory[0];
                    String time = Inventory[1];
                    String description = Inventory[2];
                    String vendor = Inventory[3];
                    float price = Float.parseFloat(Inventory[4]);

                    transLedger.put(date, new Transactions(date, time, description, vendor, price));
                }
            }
        }
        catch (IOException error){
                error.printStackTrace();
        }
    }




}
