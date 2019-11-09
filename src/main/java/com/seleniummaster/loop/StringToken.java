package com.seleniummaster.loop;
import java.util.Scanner;

public class StringToken {
    public static void main(String[] args) {
        System.out.println("Please input a string");
        Scanner input=new Scanner(System.in);
        String originalString=input.next();
        System.out.println("Actual String: "+originalString);
        int count=originalString.length();
        System.out.println(count);
        for(int i=0;i<count;i++)
        {
            System.out.println(originalString.substring(i,i+1));
        }
    }
}
