package com.seleniummaster.datatype.prerecordingvideos;
import java.util.Scanner;

 /**
* Created by SeleniumMaster on 4/19/2017.
*/
    public class DecisionMakingDemo1if {
        public static void main(String[] args) {
                    //if else statement, always uses with relational operators: ==, !=, >, >=, <, <=
                    //define a scanner object to input withdraw amount
                   System.out.println("Example 1 for conditional statement");
                   Scanner inputAmount = new Scanner(System.in);
                   System.out.println("Enter the amount to withdraw:  ");
                   int withdrawAmount = inputAmount.nextInt();
                   System.out.println("You entered:  " + withdrawAmount);
                   //balance
                   int accountBalance = 10000;
                   if (withdrawAmount < accountBalance) {
                           accountBalance = accountBalance - withdrawAmount;
                           System.out.println(String.format("Your balance is %d", accountBalance));
                       } else {
                           System.out.println("Please enter an amount less than your account balance");
                           System.out.println("Your account balance was: " + accountBalance);
                       }
                   //use conditional operators ?:
                   System.out.println("Example 2 for conditional statement");
                   int accountBalance2 = 5000;
                   System.out.println("Your initial balance:   " + accountBalance2);
                   Scanner inputAmount2 = new Scanner(System.in);
                   System.out.println("Enter the amount to withdraw:  ");
                   int withdrawAmount2 = inputAmount2.nextInt();
                   System.out.println("You entered:  " + withdrawAmount2);
                   //balance
                   int finalBalance = accountBalance2 - withdrawAmount2;
                   accountBalance2 = withdrawAmount2 < accountBalance2 ? finalBalance : accountBalance2;
                   System.out.println(String.format("Your balance is %d", accountBalance2));
               }
   }