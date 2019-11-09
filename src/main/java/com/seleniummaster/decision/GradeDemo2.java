package com.seleniummaster.decision;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class GradeDemo2 {
    public static void main(String[] args) {
        System.out.println("Please input a number between 0 and 100.");
        Scanner input = new Scanner(System.in);
        String grade = input.next();
        System.out.println("You entered " + grade);
        //if not number, print message on the screen
        if (StringUtils.isNumeric(grade) && Integer.parseInt(grade)<100 &&
            Integer.parseInt(grade)>0) {
            int grade1 = Integer.parseInt(grade);

            if (grade1 >= 90)
                System.out.println("Your grade is an A.");
            else if (grade1 > 80 && grade1 < 90)
                System.out.println("Your grade is a B.");
            else if (grade1 > 70 && grade1 < 80)
                System.out.println("Your grade is a C.");
            else
                System.out.println("You failed. Please work harder.");

        } else
            System.out.println("Please enter correct number.");
    }
}
