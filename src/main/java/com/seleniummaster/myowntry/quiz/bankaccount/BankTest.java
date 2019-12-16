package com.seleniummaster.myowntry.quiz.bankaccount;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("ئەھمەت", "ئەلى");
        bank.getCustomer(0).setAccount(new Account(2000));
        bank.getCustomer(0).getAccount().withDraw(500);
        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("ئابونتنىڭ ئىسمى: "+bank.getCustomer(0).getFirstName()+"\n"+
                " قالغان پۇل سوممىسى:  "+balance);
    }

}
