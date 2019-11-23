package com.seleniummaster.homework;

public class Week13_2 {
    public static void main(String[] args) {
        // a.
        int x=0;
        int y=0;
        if(x==0 && y==0)  { x=2;  y=2; }

        // b.
        int z=66;
        if( 1<=z && z<=100){ System.out.println(z); }

        // c.
        String s="nickels";
        if(!s.equals("nickels") || !s.equals("pennies") || !s.equals("dimes")){
        System.out.print("Money input error");
        }
    }
}
