package com.seleniummaster.loop;

public class SumDemo {
    public static void main(String[] args) {
        int sum=0;
        System.out.println(String.format("sum=%d",sum));
        for(int i=1; i<=10; i++)
        {
            System.out.println(String.format("%d+%d",i,sum));
            sum = sum+1;
           // if(i%2==0) // only print even number
            System.out.println(String.format("i=%d  sum=%d",i,sum));
        }
    }

    public static class PrintExample {
        public static void main(String[] args) {
            System.out.println("1/0");
        }
    }
}
