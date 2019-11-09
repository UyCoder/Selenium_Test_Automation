package com.seleniummaster.loop;

public class sumDemo3 {
    public static void main(String[] args) {
        int sumEven = 0;
        int sumOdd = 0;
        int evenNumber = 2;
        int oddNumber = 1;
        for (int i = 1; i <= 100; i++) {
            //if even number
            if (i % 2 == 0) {
                evenNumber = i;
                sumEven = sumEven + i;
                System.out.print(String.format("        i=%d sum=%d ",evenNumber,sumEven));
                System.out.println();
            }
            //if the number is an odd number
            else {
                oddNumber = i;
                sumOdd = sumOdd + i;
                System.out.print(String.format("                i=%d sum=%d",oddNumber,sumOdd));
            }

        }
    }
}
