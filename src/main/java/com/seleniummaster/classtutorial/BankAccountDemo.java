package com.seleniummaster.classtutorial;

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(1234567890);
        bankAccount.setFirstname("Mike");
        bankAccount.setLastname("Smith");
        bankAccount.setAccountType("Checking Account");
        bankAccount.setBalance(100);
        //
        System.out.println(bankAccount.getAccountNumber());
        System.out.println(bankAccount.getFirstname());
        System.out.println(bankAccount.getLastname());
        System.out.println(bankAccount.getAccountType());
        System.out.println(bankAccount.getBalance());
        bankAccount.deposit(500);//calling a method
        bankAccount.withDraw(100);
    }
}
