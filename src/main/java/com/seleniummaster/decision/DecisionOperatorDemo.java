package com.seleniummaster.decision;

import java.util.Scanner;

class TaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your status");
        String status = input.next();
        System.out.println();
        double rate1=0.1; //10 percent
        double rate2=0.25; //25 percent
        double singleLimit=32000;
        double marriedLimit=64000;
        System.out.println("please enter your salary");
        int salary = input.nextInt();
        System.out.println();
        double tax = 0;
        int taxpercent = 0;
        if (status.equals("single")) {
            if (salary <= 32000) {
                System.out.println("tax is 10%");
                tax = salary*rate1;
                taxpercent = 10;
            }
            else {
                System.out.println("tax ix 25%");
                tax = singleLimit* rate1+ (salary -singleLimit) *rate2;
                taxpercent = 25;
            }
        } else if (status.equals("married")) {
            if (salary <= 64000) {
                System.out.println("tax is 10%");
                tax = salary*rate1;
                taxpercent = 10;
            }
            else {
                System.out.println("tax ix 25%");
                tax = marriedLimit* rate1+ (salary -marriedLimit) *rate2;
                taxpercent = 25;
            }
        }
        System.out.println(String.format("Salary = %d; status = %s; " +
                "tax percentage = %d; total tax = %.1f", salary, status, taxpercent, tax));
    }
}

