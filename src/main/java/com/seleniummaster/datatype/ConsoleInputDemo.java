package com.seleniummaster.datatype;

import java.util.Scanner;

public class ConsoleInputDemo {
    public static void main(String[] args) {
        // define scanner object (non static object)
        Scanner input=new Scanner(System.in);

        //scanner is an object; inputName is object instance
        System.out.println("What is your name?");
        String name= input.nextLine();
        System.out.println("Your name is " +name);

        //ask age and print the age on the screen.
        System.out.println("How old are you?");
        int age=input.nextInt();
        System.out.println(String.format("Your are %d years old.",age));
    }
}
