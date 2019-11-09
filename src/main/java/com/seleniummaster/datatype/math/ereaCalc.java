package com.seleniummaster.datatype.math;

public class ereaCalc {
    public static void main(String[] args) {
        int width1=9;
        int height1=6;
        int erea1=width1*height1;
        System.out.println(String.format("%d * %d =%d",width1,height1,erea1 ));

        int width2=4;
        int height2=10;
        int erea2=width2*height2;
        System.out.println(String.format("%d * %d =%d",width2,height2,erea2 ));

        int width3=50;
        int height3=60;
        int erea3=width3*height3;
        System.out.println(String.format("%d * %d =%d",width3,height3,erea3 ));

        int width4=6;
        int height4=6;
        int erea4=width4*height4;
        System.out.println(String.format("%d * %d =%d",width4,height4,erea4 ));


        System.out.println("");
        System.out.println("======calculate with function=====");
        calculateArea(4,10);
        calculateArea(50,60);
        calculateArea(6,6);
    }

    //define a erea function
    public static void calculateArea(int width, int height){
        System.out.println(String.format("%d * %d = %d",width,height,width*height));
    }
}
