package com.seleniummaster.datatype;

public class ArithmeticOperatorDemo {
    public static void main(String[] args) {
        //calculate an area of a rectangle, find perimeter of rectangle
        int width=15;
        int height=10;
        int area=width*height;
        int perimeter=2*(width+height);
        System.out.println(String.format("area=%d",area));
        System.out.println(String.format("perimater=%d",perimeter));

        float divReasult=(float) width/height;
        System.out.println(String.format("Division Result = %f",divReasult));

        int i=0;
        int j=10;
        if(i==0){
            System.out.println("You can not divide a number by zero.");
        }
        else {
            int c = j / i;
            System.out.println(String.format("c=%d", c));
        }

        // % this synbol is for remainder
        System.out.println(5%2);
        System.out.println((float)5/2);
        //even number if you divide any number by %2 = 0
        //odd number
        System.out.println(8%4);
    }
}
