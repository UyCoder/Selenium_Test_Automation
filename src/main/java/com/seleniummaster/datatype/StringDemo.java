package com.seleniummaster.datatype;

public class StringDemo {
    public static void main(String[] args) {
        //define a string variable
        String greeting ="Hello, Selenium Master, This is a Java String.";

        // print out
        System.out.println(greeting);

        //define anaother valiaable named greeting2 and print it out on the console.
        String greeting2 = "Hey, It's me, Ahmet";
        System.out.println(greeting2);

        //print all upper case
        System.out.println(greeting.toUpperCase());
        System.out.println(greeting2.toUpperCase());

        //print all lower case
        System.out.println(greeting.toLowerCase());
        System.out.println(greeting2.toLowerCase());

        // String verification
        System.out.println(greeting.contains("Java"));
        System.out.println(greeting2.contains("Selenium"));

        //find the length of the String
        System.out.println("The Length of the  variable greeting's value "+ greeting.length());
        System.out.println(greeting2.length());

        //find a position of a character in a string
        System.out.println("The first S letter in the greeting variable " + greeting.indexOf("S"));

        //get the word "selenium master" from the greeting value
        System.out.println(greeting.substring(7,22));
        int beginPosition=greeting.indexOf("S");
        int totalLength="Selenium Master".length();
        System.out.println(greeting.substring(beginPosition,beginPosition+totalLength));



    }
}
