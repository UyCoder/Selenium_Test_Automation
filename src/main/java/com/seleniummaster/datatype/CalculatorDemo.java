package com.seleniummaster.datatype;

import java.util.Scanner;

public class CalculatorDemo {
    public static void main(String[] args) {
        // design a simple Calculator to add two number
        // you need to input two numbers from the console
        Scanner number=new Scanner(System.in);
        System.out.println("Please input first number..");
        int i1=number.nextInt();
        System.out.println("Please enter second number..");
        int i2=number.nextInt();
        System.out.println();
        System.out.println(String.format("%d + %d = %d",i1,i2,i1+i2));
        System.out.println(String.format("%d - %d = %d",i1,i2,i1-i2));
        System.out.println(String.format("%d / %d = %f",i1,i2,(float)i1/i2));
        System.out.println(String.format("%d * %d = %d",i1,i2,i1*i2));
    }
}
