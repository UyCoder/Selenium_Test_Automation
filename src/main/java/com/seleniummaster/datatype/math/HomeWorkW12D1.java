package com.seleniummaster.datatype.math;

public class HomeWorkW12D1 {
    public static void main(String[] args) {
        int a=19;
        int b=15;
        // The sum of the two numbers;
        System.out.println(String.format("%d + %d = %d",a,b,a+b));

        // The difference of the two numbers;
        System.out.println(String.format("%d - %d = %d",a,b,a-b));

        // The product (multiplication) of the two numbers;
        System.out.println(String.format("%d * %d = %d",a,b,a*b));

        // The average of the two numbers;
        System.out.println(String.format("The average of %d and %d is %d.",a,b,(a+b)/2));

        // The absolute values of the two number differences;
        System.out.println(String.format("The absolute value of the %d and %d is %d.",a ,b ,Math.abs(a-b)));

        // The maximum of the two numbers;
        System.out.println(String.format("The maximum of two numbers %d and %d is %d.",a,b,Math.max(a,b)));

        // The minimum of the two numbers;
        System.out.println(String.format("The minimum of he two numbers %d and %d is %d.",a,b,Math.min(a,b)));

        // The comparison of the two numbers
       if(a > b){
            System.out.println(a + " is greater than " + b);
        }
        else if(a < b){
            System.out.println(a + " is less than " + b);
        }
        else{
            System.out.println(a + " is equal to " + b);
        }
        System.out.println(); //add a new empty line
        System.out.println("=====Teachers way to do homework=====");
        addTwoNumbers(5,10);
        addTwoNumbers(30,40);
        subtractTwoNumbers(100,400);
        multiply(10,50);
        average(10,15);
        absoluteValue(40,60);
        maxValue(100,149);
        minValue(10,5);
        compareTwoNumbers(15,9);
    }


    //in the class the teacher do homework in this way

    public static void addTwoNumbers(int a, int b)
    {
        System.out.println(String.format("%d +%d=%d",a,b,a+b));
    }
    public static void subtractTwoNumbers(long l1, long l2)
    {
        System.out.printf("%d-%d=%d",l1,l2,l1-l2);
    }
    public static void multiply(int i1, int i2)
    {
        System.out.printf("%d*%d=%d",i1,i2,i1*i2);
    }
    public static void average(int x, int y)
    {
        float average=(float)(x+y)/2;
        System.out.println(String.format("The average of %d and %d is %f",x,y,average));
    }
    public static void absoluteValue(long x, long y)
    {
        System.out.println(String.format("Absolute value %d-%d=%d",x,y,Math.abs(x-y)));
    }
    public static void maxValue(int s1, int s2)
    {
        System.out.println(String.format("Max of %d and %d is %d",s1,s2,Math.max(s1,s2)));
    }
    public static void minValue(int s1, int s2)
    {
        System.out.println(String.format("Min of %d and %d is %d",s1,s2,Math.min(s1,s2)));
    }
    public static void compareTwoNumbers(int i1, int i2)
    {
        if(i1>i2)
            System.out.println(i1 + " greater than "+ i2);
        else
            System.out.println(i1 + " less than "+ i2);
    }


}
