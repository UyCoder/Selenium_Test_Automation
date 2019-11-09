package com.seleniummaster.loop;

import java.util.Scanner;

public class sumDemo2 {
    public static void main(String[] args) {
        int sum=0;
        Scanner input= new Scanner(System.in);
        System.out.print("Please input a number from the console: ");
        int range=input.nextInt();


        for(int i = 1; i <= range; i++)
        {
            sum = sum+1;
           // if(i%2==0) // only print even number
            System.out.println(String.format("i=%d   sum=%d",i,sum));
        }
    }
}
