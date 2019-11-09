package com.seleniummaster.loop;

import java.util.Scanner;

public class starDemo2input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the line number: ");
        int rowNumber=input.nextInt();
        for (int row=1; row<=rowNumber ; row++)
        {
            for (int column=1; column<=row ;column++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
