package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.AccLedgerApp.ledgerScreen;
import static com.pluralsight.CSVReader.readTransactions;
import static com.pluralsight.CSVReader.transLedger;

/*
This is my Ledger functions class.
In here users will be able to view all transaction history and sort based on date (newest to oldest) and by type (deposit or payment)
 */
public class LedgerFunctions {
    public static Scanner ledgerInput = new Scanner(System.in);

    public static void displayLedger() {
        readTransactions();
        System.out.println("All Transaction History");
        for (String hashKey : transLedger.keySet()) {
            System.out.println("Date|Time|Description|Vendor|Amount" + "\n"
                    + transLedger.get(hashKey).getDate()
                    + transLedger.get(hashKey).getTime() + "|"
                    + transLedger.get(hashKey).getDescription() + "|"
                    + transLedger.get(hashKey).getVendor() + "|"
                    + transLedger.get(hashKey).getAmount() + "\n");
        }
        System.out.println("Enter X when you want to return to Ledger Screen");

        ledgerInput.nextLine();
        ledgerScreen();
    }

    public static void displayDeposits() {
        System.out.println("All Deposit History");
        for (String hashKey : transLedger.keySet()) {
            if (transLedger.get(hashKey).getAmount() > 0) {
                System.out.println("Date|Time|Description|Vendor|Amount" + "\n"
                        + transLedger.get(hashKey).getDate()
                        + transLedger.get(hashKey).getTime() + "|"
                        + transLedger.get(hashKey).getDescription() + "|"
                        + transLedger.get(hashKey).getVendor() + "|"
                        + transLedger.get(hashKey).getAmount() + "\n");
            }
        }
        System.out.println("Enter X when you want to return to Ledger Screen");

        ledgerInput.nextLine();
        ledgerScreen();


    }

    public static void displayPayments() {
        System.out.println("All Payment History");
        for (String hashKey : transLedger.keySet()) {
            if (transLedger.get(hashKey).getAmount() < 0) {
                System.out.println("Date|Time|Description|Vendor|Amount" + "\n"
                        + transLedger.get(hashKey).getDate()
                        + transLedger.get(hashKey).getTime() + "|"
                        + transLedger.get(hashKey).getDescription() + "|"
                        + transLedger.get(hashKey).getVendor() + "|"
                        + transLedger.get(hashKey).getAmount() + "\n");
            }
        }
        System.out.println("Enter X when you want to return to Ledger Screen");

        ledgerInput.nextLine();
        ledgerScreen();


    }
}


