package com.seleniummaster.myowntry.quiz;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String q1 = "What color are apples?\n" +
                "(a)Red\n(b)Orenge\n(c)Magenta\n";
        String q2 = "What color are bananas?\n" +
                "(a)Red\n(b)Yellow\n(c)Blue\n";

        // we can add new qustion and answers in this array
        Question [] questions={
                new Question(q1,"a"),
                new Question(q2,"b")
        };
        takeTest(questions);
    }

    public static void takeTest(Question[] questions) {
        int score =0;
        Scanner keyboardinput= new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].prompt);
            String answer= keyboardinput.nextLine();
            if (answer.equalsIgnoreCase(questions[i].answer)) {
                score++;// if answer corret it will add one score
            }
        }
        double finalScore = 100 * ((double) score / (double) questions.length);
        System.out.println(finalScore);

        //System.out.println("You got "+score +"/" +questions.length);
    }
}
