package com.pluralsight;
import java.io.*;
import java.util.*;
import java.time.*;
public class Home {
    public static void main(String[] args) {
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("Welcome to your bank! What would you like to do?" + "\n" + "Choose from the options below: " + "\n" + "1: Make a Deposit" +"\n" + "2: Track a Payment" + "\n" + "3: Read Ledger" + "\n" + "4: Exit");
            Scanner  scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
             switch (userChoice) {
                 case 1: //write deposit info to csv file
                    break;
                case 2: //write payment info to csv file
                    break;
                case 3: //read entire ledger (shows transaction history)
                    break;
                case 4: //exits application
                    break;
             }
        }


    }



}
