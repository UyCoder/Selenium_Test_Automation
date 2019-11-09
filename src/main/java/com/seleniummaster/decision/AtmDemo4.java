package com.seleniummaster.decision;

import java.util.Scanner;

public class AtmDemo4 {
    public static void main(String[] args) {
        double accountBalance = 5000;
        int pin = 1234;
        Scanner pinInput = new Scanner(System.in);
        System.out.println("Enter PIN ...");
        String pinEntered = pinInput.nextLine();
        if(pinEntered.length()<4){
            System.out.println("You entered less than 4 digits pin, please try again...");
            System.exit(1); //asigning exit code in java program
        }
        //Let's check the pin number against the pin in the banking system
        if (pinEntered.equals(String.valueOf(pin))) {
            System.out.println("Please input the withdraw amount..");
            Scanner input = new Scanner(System.in);
            double withdrawAmount = input.nextDouble();
            //make decision
            if (withdrawAmount < accountBalance) {
                double balance = accountBalance - withdrawAmount;
                System.out.println("Your balance is " + balance);
            } else {
                System.out.println("You have insufficient fund. Please check the amount..");
                System.out.println("Please deposit more money.");
            }
        } else {
            System.out.println("Incorrect pin.");
        }
    }
}