package com.seleniummaster.classtutorial;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.addNumbers(10, 20));
        System.out.println(calculator.addNumbers(10, 15, 25, 45, 67));
        System.out.println(calculator.addNumbers(10.5, 129.90));
        System.out.println(calculator.addNumbers(10, 5));
    }
}
