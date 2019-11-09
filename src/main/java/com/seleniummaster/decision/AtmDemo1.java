package com.seleniummaster.decision;

import java.util.Scanner;

public class AtmDemo1 {
    public static void main(String[] args) {
        double accountBalance=5000;
        System.out.println("Please input the withdraw amount..");
        Scanner input=new Scanner(System.in);
        double withdrawAmount=input.nextDouble();

        //make decision
        if(withdrawAmount<accountBalance)
        {
            double balance=accountBalance-withdrawAmount;
            System.out.println("Your balance is "+balance);
        }
    }
}



