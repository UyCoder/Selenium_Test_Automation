package com.seleniummaster.datatype.prerecordingvideos;
import java.util.Scanner;
    public class DecisionMakingDemo2ifelseif {
    /**
     * Created by SeleniumMaster on 4/19/2017.
     */
    public static void main(String[] args) {
        //if, else if, else statement, multiple alternatives
         //You must sort the conditions and test against the largest cutoff first
        Scanner inputGrade=new Scanner(System.in);
             System.out.println("Enter your grade:  ");
        int score=inputGrade.nextInt();
             System.out.println("You entered:  "+score);
        if(score>=90)
             System.out.println("Your grade is A");
        else if (score>=80 && score<90)
             System.out.println("Your grade is B");
        else if (score>=70 && score<80)
             System.out.println("Your grade is C");
        else
             System.out.println("You failed");
        }
}

