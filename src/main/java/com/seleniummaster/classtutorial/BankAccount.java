package com.seleniummaster.classtutorial;

public class BankAccount {
    private long accountNumber;
    private String firstname;
    private String lastname;
    private double balance;
    private String accountType;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void deposit(double depositAmount) {
        this.balance = this.balance + depositAmount;
        System.out.println(this.balance);
    }

    public void withDraw(double withDrawAmount) {
        if (withDrawAmount < this.balance) {
            this.balance = this.balance - withDrawAmount;
            System.out.println("Balance " + this.balance);
        } else {
            System.out.println("Insufficient Fund");
        }

    }

    public void getLastname(String smith) {
    }
}
