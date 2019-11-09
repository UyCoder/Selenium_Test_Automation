package com.seleniummaster.loop;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        System.out.println("Please input a String: ");
        Scanner input = new Scanner(System.in);
        String originalString=input.next();
        System.out.println("Actual String: "+originalString);
        int count=originalString.length();
        for(int i=count-1; i>=0; i--)
        {
            System.out.print(originalString.substring(i,i+1));
        }
    }
}
