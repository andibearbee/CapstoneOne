package com.pluralsight;
import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class HomeFunctions {
    public static Scanner scanner = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    //need to save dates input from the user in a way the computer can sort them -- public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern (YYYY-MM-DD)



    public static void addDeposit() {
        try {
        System.out.println("What date did you make deposit? YYYY-MM-DD");
        LocalDate date = LocalDate.parse(scanner.next());

        System.out.println("What was the time? HH:MM");
        String time = scanner.next();

        System.out.println("What's the type of deposit?  ");
        String description = scanner.next().trim();
        scanner.nextLine();

        System.out.println("Where is the deposit from? ");
        String vendor = scanner.next().trim();

        System.out.println("What's the amount? ");
        float amount = scanner.nextFloat();
        scanner.nextLine();


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv", true));


        bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "\n");
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
            LocalDate date = LocalDate.parse(scanner.next());

            System.out.println("What was the time? HH:MM");
            String time = scanner.next();

            System.out.println("What's the item purchased?  ");
            String description = scanner.next().trim();
            scanner.nextLine();

            System.out.println("Where did this payment go? ");
            String vendor = scanner.nextLine().trim();

            System.out.println("What's the amount? ");
            float amount = scanner.nextFloat();
            scanner.nextLine();
            amount *= -1;
            String amountDF =df.format(amount);


            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv", true));


            bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amountDF + "\n");
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }

}



