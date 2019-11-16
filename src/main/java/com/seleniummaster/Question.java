package com.seleniummaster;

import java.util.Scanner;

public class Question {
        public static void main(String[] args) {
            // print out the question
            System.out.println("========================================");
            System.out.println("In a computer system, a RAM stands for ? ");
            System.out.println("========================================");
            System.out.println("A. Read only memory ");
            System.out.println("B. Random access memory ");
            System.out.println("C. Both read only and random access memory");
            System.out.println("D. None of the above");

            //add scanner
            Scanner scan = new Scanner(System.in);
            System.out.println("Select one:");
            String seletedAnswer= scan.next();


            // if statement for the answer
            if (seletedAnswer=="A"){
                System.out.println("Good job!");
            } else {
                System.out.println("You selected the wrong answer.");
            }
            // My question:
            // Even if I choose the write answer, it always shows 'wrong'.
            // When I use char datatype on line 19 it worked.
            // line 19: char seletedAnswer= scan.next().charAt(0);
            // line 23: if (seletedAnswer=='A'){
            // جاۋابىنى ئۆزۈم تاپتىم.. چۈنكى 23- قۇرىدىكى ئىف نىڭ شەرتىگە == يېزىلمايدۇ.
            // چۈنكى شەرتى سترىڭ بولغاچقا مۇنداق يېزىش كېرەك:
            //  seletedAnswer.equalsIgnoreCase("A")



        }
}
