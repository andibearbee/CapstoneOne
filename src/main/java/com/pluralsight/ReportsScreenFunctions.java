package com.pluralsight;

import java.time.LocalDate;
import java.time.Month;

import static com.pluralsight.AccLedgerApp.reportsScreen;
import static com.pluralsight.CSVReader.transLedger;
import static com.pluralsight.CSVReader.readTransactions;

/* The reports screen functions are housed here and called to in the App Class.
These methods allow for the user to filter reports based on the following:
monthToDate();
previousMonth();
yearToDate();
previousYear();
searchByVendor(); -
And they can also return to home
 */
public class ReportsScreenFunctions {

    public static void monthToDate() {
        //display everything in current month
        readTransactions();
        System.out.println("Month to Date Report: \n");
        for (String hashKey : transLedger.keySet()) {
            LocalDate today = LocalDate.now();
            Month month = transLedger.get(hashKey).getDate().getMonth();
            Month localMonth = today.getMonth();
            int year = transLedger.get(hashKey).getDate().getYear();
            int localYear = today.getYear();


            if ((month == localMonth) && (year == localYear)) {
                System.out.println("Date|Time|Description|Vendor|Amount" + "\n"
                        + transLedger.get(hashKey).getDate()
                        + transLedger.get(hashKey).getTime() + "|"
                        + transLedger.get(hashKey).getDescription() + "|"
                        + transLedger.get(hashKey).getVendor() + "|"
                        + transLedger.get(hashKey).getAmount() + "\n");
            }
        }
        //back to reports menu

//
           }

    public static void previousMonth() {
        //display everything in previous month
//        System.out.println("Previous Month Report: \n");
//        for (String hashKey : transLedger.keySet()) {
//            LocalDate today = LocalDate.now();
//            Month month = transLedger.get(hashKey).getDate().getMonth();
//            Month localMonth = today.getMonth();
//            int year = transLedger.get(hashKey).getDate().getYear();
//            int localYear = today.getYear();
//
//
//            if ((month == localMonth) && (year == localYear)) {
//                System.out.println("Date|Time|Description|Vendor|Amount" + "\n"
//                        + transLedger.get(hashKey).getDate()
//                        + transLedger.get(hashKey).getTime() + "|"
//                        + transLedger.get(hashKey).getDescription() + "|"
//                        + transLedger.get(hashKey).getVendor() + "|"
//                        + transLedger.get(hashKey).getAmount() + "\n");
//            }
//        }



    }

    public static void yearToDate() {
        //display everything in current year




    }

    public static void previousYear() {
        //display everything in previous year



    }

    public static void searchByVendor() {
        System.out.println("Currently Under Construction: Check Back Later.");
        reportsScreen();
    }

    public static void backToReports() {


    }
}
