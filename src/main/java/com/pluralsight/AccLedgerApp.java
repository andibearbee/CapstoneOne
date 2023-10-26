package com.pluralsight;
import static com.pluralsight.HomeFunctions.*;
import static com.pluralsight.CSVReader.readTransactions;
import static com.pluralsight.LedgerFunctions.*;
/*
This is the main menu. From here users will be able to navigate through the app and complete different actions.
Such as adding to the transaction history and viewing their history.
 */

public class AccLedgerApp {
    public static void main(String[] args) {
        readTransactions();
        homeScreen();
    }

    public static void homeScreen() {
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("Welcome to your Transaction History! What would you like to do?"
                    + "\n" + "Choose from the options below: "
                    + "\n" + "D: Add Deposit Information"
                    + "\n" + "P: Add Payment Information"
                    + "\n" + "V: View Transaction History"
                    + "\n" + "X: Exit");

            String homeAction = scanner.nextLine().toUpperCase().trim();
            switch (homeAction) {
                case "D": //write deposit info to csv file
                    addDeposit();
                    break;

                case "P": //write payment info to csv file
                    addPayment();
                    break;

                case "V": //read entire ledger (display transaction history)
                    ledgerScreen();
                    break;

                case "X"://exits application
                    System.exit(0);
                    break;

                default:
                    appRunning = false;
                    System.out.println("Not a viable entry. Please choose one of the following: D, P, V, or X. ");
            }
        }
    }

    public static void ledgerScreen() {
        //switch statement to allow for user choice
        System.out.println("Welcome to your Ledger, which transaction history would you like to view?" +
                "\n A: Display All transactions " +
                "\n D: Display deposits history " +
                "\n P: Display payment history " +
                "\n R: Search my Reports" +
                "\n H: Return to Home");

        String ledgerAction = scanner.nextLine().toUpperCase().trim();
        switch (ledgerAction) {
            case "A":
                displayLedger();
                break;
            case "D":
                displayDeposits();
                break;
            case "P":
                displayPayments();
                break;
            case "R": //reportsScreen();
                break;
            case "H": homeScreen();
                break;
            default:
                System.out.println("Not a viable entry. Please choose one of the following: A, D, P, R, or H.");
        }


    }


        public static void reportsScreen () {
            //switch statement to allow for user choice
            System.out.println("Welcome to your Reports, how would you like to view?" +
                    "\n M: Month to Date " +
                    "\n PM: Previous Month" +
                    "\n Y: Year to Date" +
                    "\n PY: Previous Year" +
                    "\n V: Search by Vendor" +
                    "\n B: Back to Reports" +
                    "\n H: Home Screen");

            String ledgerAction = scanner.nextLine().toUpperCase().trim();
            switch (ledgerAction) {
                case "M":
                    //monthToDate();
                    break;
                case "PM":
                    //previousMonth();
                    break;
                case "Y":
                    //yearToDate();
                    break;
                case "PY":
                    //previousYear();
                    break;
                case "V":
                    //searchByVendor();
                    break;
                case "B":
                    //backToReports
                    break;
                case "H": homeScreen();
                    break;
                default:
                    System.out.println("Not a viable entry. Please choose one of the following: M, PM, Y, PY, V, B, or H. ");
            }



        }
    }

