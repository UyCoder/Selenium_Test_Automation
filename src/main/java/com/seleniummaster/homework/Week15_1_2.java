package com.seleniummaster.homework;

public class Week15_1_2 {
    public static void main(String[] args) {
        double[] values=new double[10];
        for(int i=0;i<10;i++){
            values[i] = i*i;
        }
        for (double element : values) {
            System.out.println(element);
        }
    }
}
