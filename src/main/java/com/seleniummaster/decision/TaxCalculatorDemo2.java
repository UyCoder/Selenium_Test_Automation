package com.seleniummaster.decision;
import java.util.Scanner;

/**
 * This is a code written by teacher.
 * The function is the same but code more advanced.
 */
public class TaxCalculatorDemo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your status");
        String filingStatus= input.next();
        System.out.println("Please input your salary");
        Scanner salaryInput=new Scanner(System.in);
        int salary=salaryInput.nextInt();
        System.out.println("Please enter the tax Limit");
        int taxLimit=salaryInput.nextInt();
        taxCalculation(salary,taxLimit,filingStatus);
    }
    public static void taxCalculation(int salary, int taxLimit, String filingStatus)
    {
        double tax=0;
        double overTax=taxLimit*0.1+(salary-taxLimit)*0.25;
        double baseTax=salary*0.1;
        if(filingStatus.equalsIgnoreCase("single"))
        {
            tax=salary<=taxLimit?baseTax:overTax;
        }
        else {
            tax=salary<=taxLimit?baseTax:overTax;
        }
        System.out.println(String.format("Salary %d   Tax %.1f",salary,tax));
    }
}

