package com.pluralsight;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.time.*;
public class Home {
    public static Scanner scanner = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    //need to save dates input from the user in a way the computer can sort them -- public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern (YYYY-MM-DD)

    public static void main(String[] args) {
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("Welcome to your Transaction History! What would you like to do?" + "\n" + "Choose from the options below: " + "\n" + "1: Add Deposit Information" + "\n" + "2: Add Payment Information" + "\n" + "3: Read Transaction History" + "\n" + "4: Exit");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1: //write deposit info to csv file
                    addDeposit();
                    break;
                case 2: //write payment info to csv file
                   addPayment();
                    break;
                //read entire ledger (display transaction history)
                case 3: //ledger screen
                    break;
                //exits application
                case 4:
                    System.exit(0);
                    break;
                default:
                    appRunning = false;
            }

        }


    }

    public static void addDeposit() {
        try {
        System.out.println("What date did you make deposit? YYYY-MM-DD");
        String date = scanner.next();

        System.out.println("What was the time? HH:MM");
        String time = scanner.next();

        System.out.println("What's the type of deposit?  ");
        String description = scanner.next().trim();

        System.out.println("Where is the deposit from? ");
        String vendor = scanner.next().trim();

        System.out.println("What's the amount? ");
        float amount = scanner.nextFloat();
        scanner.nextLine();


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv", true));


        bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
        catch (IOException error) {
            error.printStackTrace();
        }
    }
    public static void addPayment() {
        try {
            System.out.println("What date did you make the purchase? YYYY-MM-DD");
            String date = scanner.next();

            System.out.println("What was the time? HH:MM");
            String time = scanner.next();

            System.out.println("What's the item purchased?  ");
            String description = scanner.next().trim();

            System.out.println("Where did this payment go? ");
            String vendor = scanner.next().trim();

            System.out.println("What's the amount? ");
            float amount = scanner.nextFloat();
            scanner.nextLine();
            amount *= -1;
            String amountDF =df.format(amount);


            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv", true));


            bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amountDF);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }

}
