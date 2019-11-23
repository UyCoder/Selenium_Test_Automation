package com.seleniummaster.homework;

public class Week13_1_9 {
    public static void main(String[] args) {
        int a = 100;
        int digitCounts = String.valueOf(a).length();
        switch (digitCounts) {
            case 1:
                System.out.println("This number is less than 9");
                break;

            case 2:
                System.out.println("This number is between 10 and 99");
                break;
            case 3:
                System.out.println("This number is more than or equal to 100");
                break;
            default:
                System.out.println("This is a number");
        }
    }
}
