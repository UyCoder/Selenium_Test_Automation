package com.seleniummaster.decision;

import java.util.Scanner;

public class AtmDemo2 {
    public static void main(String[] args) {
        double accountBalance = 5000;
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
    }
}
