package com.seleniummaster.datatype;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner number=new Scanner(System.in);
        System.out.println("please enter a number: ");
        if (number.nextInt()%2==0)
            System.out.println("You entered an even number");
        else
            System.out.println("Your entered an odd number.");
    }
}
