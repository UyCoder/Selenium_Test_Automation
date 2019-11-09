package com.seleniummaster.loop;

public class whileDemo2 {
    public static void main(String[] args) {
        double balance = 50000;
        double targetBalance = 300000;
        int year = 0;
        double rate = 0.05;
        // change while loop to do-while loop
        do {
            year++;
            double interest = balance * rate;
            balance = balance + interest;
            System.out.println(String.format("Year %d Interest %.5f Balance %.2f ", year, interest, balance));
        } while (balance < targetBalance);
        System.out.println("Total years: " + year);
        System.out.println("Final Balance: " + balance);

    }
}
