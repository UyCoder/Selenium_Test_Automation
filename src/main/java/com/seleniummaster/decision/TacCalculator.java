package com.seleniummaster.decision;

import java.util.Scanner;

public class TacCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your status");
        String status = input.next();
        System.out.println();
        double rate1=0.1; // 10 percent
        double rate2=0.25; // 25 prescent
        double singleLimit=32000;
        double marriedLimit=6000;

        System.out.println("please enter your salary");
        int salary = input.nextInt();
        System.out.println();
        int tax = 0;
        int taxpercent = 0;
        if (status.equals("single")) {
            if (salary <= 32000) {
                System.out.println("tax is 10%");
                tax = (int) ((double) salary*rate1);
                taxpercent = 10;
            }
            else {
                System.out.println("tax ix 25%");
                tax = (int) ((salary - singleLimit * 25) / 100);
                taxpercent = 25;
            }
        } else if (status.equals("married")) {
            if (salary <= 64000) {
                System.out.println("tax is 10%");
                tax = (salary * 10) / 100;
                taxpercent = 10;
            } else {
                System.out.println("tax is 25%");
                tax = (salary * 25) / 100;
                taxpercent = 25;
            }
        }

        System.out.println(String.format("Salary = %.f; status = %s; tax percentage = %d; total tax = %d", salary, status, taxpercent, tax));
    }
}
