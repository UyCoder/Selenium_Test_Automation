package com.seleniummaster.datatype.prerecordingvideos;
import java.util.Scanner;
public class DecisionMakingDemo3switch {
   /**
   * Created by SeleniumMaster on 4/19/2017.
   */
       public static void main(String[] args)
       {
         //Use switch
         Scanner inputGradeLetter=new Scanner(System.in);
         System.out.println("Enter your grade:  ");
       char gradeLetter=inputGradeLetter.next().charAt(0);
        System.out.println("You entered:  "+gradeLetter);
        gradeLetter= Character.toUpperCase(gradeLetter);
        switch (gradeLetter) {
             case 'A':
                    System.out.println("Your grade is between 90 - 100");
                    break;

             case 'B':
                     System.out.println("Your grade is between 80 - 90");
                     break;

             case 'C':
                     System.out.println("Your grade is between 70 - 80");
                     break;

             case 'D':
                     System.out.println("Your grade is between 60 - 70");
                     break;
             case 'F':
                     System.out.println("Your grade is less than 60");
                     break;
             default:
                     System.out.println("Please enter a proper grade letter: A, B,C,D, F");
                     break;
              }
       }
}

