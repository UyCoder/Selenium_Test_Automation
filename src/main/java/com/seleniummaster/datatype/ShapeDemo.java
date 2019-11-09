package com.seleniummaster.datatype;

public class ShapeDemo {
    public static void main(String[] args) {

        //in-class exercise
        System.out.println("* * * *");
        System.out.println("*     *");
        System.out.println("*     *");
        System.out.println("* * * *");
        System.out.println("--------");

        //another way to do exercise
        System.out.println("* * * * \n*     *\n*     *\n* * * *");
        System.out.println("--------");

        //another way to do it
        String star1="* * * *";
        String star2="*     *";
        String star3="*     *";
        String star4="* * * *";
        System.out.println(star1+ "\n" +star2+ "\n" +star3+ "\n" +star4);
        System.out.println("--------");

        //teacher shows little trick..
        for(int i=1;i<100;i++)
        {
            for(int j=1;j<100;j++){
                System.out.println(String.format("%d*%d=%d",i,j,i*j));
            }
            System.out.println();
        }
    }
}
