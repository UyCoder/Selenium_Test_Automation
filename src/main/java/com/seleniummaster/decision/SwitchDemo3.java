package com.seleniummaster.decision;

import java.util.Scanner;

public class SwitchDemo3 {
    public static void main(String[] args) {
        /**
         *  Input a number from the screen
         * if the number is one digit, print "the number is less than 9"
         * if the number is two digits, print "the number is between 10 and 99"
         * if the number is three digits, print "the number is between 100 and 999"
         * else
         * print "this number is greater than or equal to 1000"
         */
        System.out.println("Please input a number.");
        Scanner number = new Scanner(System.in);
        int value=number.nextInt();
        if (value< 0) {
            System.out.println("Your number is less than zero.");
        } else {

            int digitCount = (String.valueOf(value).length());
            switch (digitCount) {
                case 1:
                    System.out.println("This number is less than 10.");
                    break;
                case 2:
                    System.out.println("This number is between 10 and 99.");
                    break;
                case 3:
                    System.out.println("This number is between 100 and 999.");
                    break;
                default:
                    System.out.println("This number is greater than or equal to 1000");
                    break;
            }
        }
    }
}
