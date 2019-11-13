package com.seleniummaster.loop;

public class loopBreakDemo {
    public static void main(String[] args) {
       for(int i=1; i<=1000; i++)
       {
           System.out.println(i+" ");
           if (i>=550)
               break;
       }
    }

}
