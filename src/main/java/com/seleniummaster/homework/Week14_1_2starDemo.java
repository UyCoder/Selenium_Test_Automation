package com.seleniummaster.homework;

import java.util.Scanner;

class Week14_1_2triangleDemo
{
    public static void main(String[] args)
    {
        System.out.println("Please enter the rows for the Triangle: ");
        Scanner scan=new Scanner(System.in);
        int rows= scan.nextInt();

        for(int row =1; row<= rows; row++)
        {
            for(int col=1; col<=Math.pow(2,row); col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
