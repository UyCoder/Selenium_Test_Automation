package com.seleniummaster.loop;

public class multiplicationChart2 {
    public static void main(String[] args) {
        //print out a multiplication table from 1 to 9
        for(int i=1;i<=9;i++)
        {
            // just changed 'j<=9' to 'j<=i'
            for(int j=1;j<=i;j++)
            {
                int multply=i*j;
                System.out.print(String.format("%d*%d=%d\t",i,j,multply));//used tab
            }
            System.out.println();//add empty line
        }
    }
}
