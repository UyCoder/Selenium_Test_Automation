package com.seleniummaster.basic.homework;

public class Week13_1_1 {
    public static void main(String[] args) {
        int amount = 1000;
        int balance = 3500;
        int newBalance = balance - amount;
        if (amount <= balance)
            balance = newBalance;
        System.out.println(balance);
    }


}
