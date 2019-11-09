package com.seleniummaster.decision;

import java.util.Scanner;

public class GradeDemo {
    public static void main(String[] args) {
        System.out.println("Please input a number between 0 and 100.");
        Scanner input=new Scanner(System.in);
        int grade=input.nextInt();
        System.out.println("You entered "+grade);
        if(grade>=90)
            System.out.println("Your grade is an A.");
        else if(grade>80 && grade<90)
            System.out.println("Your grade is a B.");
        else if(grade>70 && grade<80)
            System.out.println("Your grade is a C.");
        else
            System.out.println("You failed. Please work harder.");

    }
}
