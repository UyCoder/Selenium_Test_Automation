package com.seleniummaster.myowntry.quiz.bankaccount;

public class Account {
    private double balance;

    public Account(double init_balance) {
        this.balance=init_balance;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("مۇۋاپپىقىيەتىلىك پۇل ساقلاندى.");
        }
    }

    public void withDraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("مۇۋاپپىقىيەتلىك پۇل قويۇلدى.");
        } else {
            System.out.println("پۇلىڭىز يەتمىدى.");
        }
    }
}
