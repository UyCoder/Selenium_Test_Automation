package com.seleniummaster.classtutorial;

public class MethodOverrideDemo {
    public static void main(String[] args) {
        ClassA classA = new ClassA(); // instanciation from parent class
        classA.printInformation();
        classA.sum(10,20);

        //method overriding
        ClassA myClass = new ClassB(); // instanciation from child class
        myClass.printInformation();
        myClass.sum(10,20);

    }
}
