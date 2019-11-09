package com.seleniummaster.basic.homework;

public class Week13_1_2 {
    public static void main(String[] args) {
        int amount = 1000;
        int balance = 3500;
        if (amount <= balance) {
            int newBalance = balance - amount;
            balance = newBalance;
            System.out.println(balance);
        }
    }

}
