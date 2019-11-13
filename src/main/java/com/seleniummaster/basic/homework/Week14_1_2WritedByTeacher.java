package com.seleniummaster.basic.homework;

import java.util.Scanner;

/**
 * 1. Write a Java program that asks the user to enter an integer from the console
 * and then print out all prime numbers up to that integer.
 * For example, when the user enters 30, the program should print out
 * 2,3,5,7,11,13,17,19,23,29
 * <p>
 * Recall that a number is a prime number
 * if it is not divisible by any number except 1 and itself.
 */

public class Week14_1_2WritedByTeacher {
        public static void main(String[] args) {
            System.out.print("Please input a number from the console: ");
            Scanner input=new Scanner(System.in);
            int number=input.nextInt();
            String primeNumbers="";
            int totalPrime=0;  //initial prime number count
            for(int i=2;i<=number;i++)  //loop the number up to the number from the console
            {
                int count=0;
                for(int j=1;j<=i;j++)  //for ever number, we check the number from 1 up to that number
                {
                    if(i%j==0)
                    {
                        count++;
                    }
                }
                if(count==2)
                {
                    primeNumbers=primeNumbers+","+i;
                    totalPrime++;
                }
            }
            System.out.println(primeNumbers);
            System.out.println("Total prime numbers: "+totalPrime);
        }
    }
