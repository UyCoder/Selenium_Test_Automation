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
public class Week14_1_2CopiedFromInternet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Variable declaration.
        int limit;

        // get input till which prime number to be printed
        System.out.print("Enter an integer (2 or above): ");
        limit = scan.nextInt();
        //scan.close();

        if (limit >= 2) {
            System.out.println("The prim numbers up to your integer are: "
                    + limit + "\n");
            for (int i = 1; i <= limit; i++) {
                // print prime numbers only
                if (isPrime(i)) {
                    System.out.print(i + ",");
                }
            }
        } else
            System.out.println("Number is not vaild");

    }

    // Prime number is not divisible by any number other than 1 and itself
    // return true if number is prime.
    public static boolean isPrime(int n) {
        if (n % 2 == 0)
            // The only even prime is 2.
            return (n == 2);
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
