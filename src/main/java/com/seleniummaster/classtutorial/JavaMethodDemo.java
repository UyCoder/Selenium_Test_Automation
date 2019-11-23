package com.seleniummaster.classtutorial;

public class JavaMethodDemo {
    // define a method to calculate area of a rectangle
    // define a method to calculate an area of a circle
    // define a method to add two numbers
    // define a method to add multiple numbers in an array

    public int calculateRectangleArea(int width, int height) {
        int area = width * height;
        return area;
    }

    public double calculateCircleArea(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    public long addTwoNumbers(long number1, long number2) {
        return number1 + number2;
    }

    public int sumOfNumbers(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum = sum + n;
        }
        return sum;
    }

    public Person addNewPerson(String firstName, String lastName, boolean isMale) {
        //return new Person(firstName, lastName, isMale);
        Person person = new Person(firstName, lastName, isMale);
        return person;
    }
    //print each letter of a word
    public static void parseStringToLetter(String info) {
        //array index, for each loop, substring
        int StringLength = info.length();
        for (int i = 0; i < StringLength ; i++) {
            System.out.println(info.substring(i,i+1));
        }
    }
}
