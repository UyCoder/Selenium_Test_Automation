package com.seleniummaster.datatype;

public class argumentdemo {
    public static void main(String[] args) {
        //use argument value in the calculation
        int x=Integer.parseInt(args[0]);
        int y=Integer.parseInt(args[1]);
        int z=Integer.parseInt(args[2]);
        System.out.println(String.format("%d+%d+%d=%d",x,y,z,x+y+z));
    }
}
