package com.seleniummaster.loop;

public class SumDemo4 {
    public static void main(String[] args) {

        int evenSum=0;
        //do sum of even number from 1 to 100
        for(int i=2; i<=100;i=i+2)
        {
            evenSum=evenSum+i;
            System.out.println(i +" "+evenSum);
        }
        //do sum of odd number from 1 to 100
        int oddSum=0;
        for(int j=1; j<=100; j=j+2)
        {
            oddSum=oddSum+j;
            System.out.println(j+" "+oddSum);
        }
    }
}
