package com.seleniummaster;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        // print out the question
        System.out.println("========================================");
        System.out.println("In a computer system, a RAM stands for ? ");
        System.out.println("========================================");
        System.out.println("A. Read only memory ");
        System.out.println("B. Random access memory ");
        System.out.println("C. Both read only and random access memory");
        System.out.println("D. None of the above");
        //add scanner feature
        Scanner scan = new Scanner(System.in);
        System.out.println("Select one:");
        String seletedAnswer =scan.next();

        // if statement for the answer if its wrong or right
        if (seletedAnswer.equalsIgnoreCase("A")) {
            System.out.println("Good job!"); //if select right answer, terminate the code.
        } else { // if not select right answer, begin 'try again' process
            while (true) {
                System.out.println("You selected the wrong answer.");
                System.out.println("Try again:");
                String nextTryAnswer = scan.next();
                if (nextTryAnswer.equalsIgnoreCase("A")) { // select right answer on next try, it will terminate code.
                    System.out.println("Good job!");
                    break;
                }
            }
        }
    }
}
// My question:
// Even if I choose the write answer, it always shows 'wrong'.
// When I use char datatype on line 19 it worked.
// line 19: char seletedAnswer= scan.next().charAt(0);
// line 23: if (seletedAnswer=='A')
//  seletedAnswer.equalsIgnoreCase("A")
