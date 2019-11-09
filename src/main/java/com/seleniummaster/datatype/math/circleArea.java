package com.seleniummaster.datatype.math;

public class circleArea {
    public static void main(String[] args) {
        circleArea(10);
        circleArea(20);

    }
    //define a function for calculate circle area
    public static void circleArea(int r){
        float area= (float) Math.PI*r*r;
        System.out.println(String.format("The erea of the circle that it's radius %d is %.4f",r,area));
        }



}


