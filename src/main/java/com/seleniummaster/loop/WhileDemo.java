package com.seleniummaster.loop;

public class WhileDemo {
    public static void main(String[] args) {
        double balance=50000;
        double targetBalance=300000;
        int year=0;
        double rate=0.05;
        //after how many years, I can reach the target
        while(balance<targetBalance) // when ever condition true while will stop
        {
            year++;
            double interest=balance*rate;
            balance=balance+interest;
            System.out.println(String.format("Year %d Interest %.5f Balance %.2f ", year,interest,balance));
        }
        System.out.println("Total years: "+ year);
        System.out.println("Final Balance: "+balance);

    }
}
