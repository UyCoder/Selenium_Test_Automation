package com.seleniummaster.loop;

public class multiplicationChart {
    public static void main(String[] args) {
        //print out a multiplication table from 1 to 9
        for(int i=1;i<9;i++)
        {
            for(int j=1;j<=9;j++)
            {
                int multply=i*j;
                System.out.print(String.format("  %d*%d=%d  ",i,j,multply));
            }
            System.out.println();//add empty line
        }
    }
}
