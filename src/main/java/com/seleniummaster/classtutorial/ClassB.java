package com.seleniummaster.classtutorial;

public class ClassB extends ClassA {// ClassA is parent class of ClassB

    public void printInformation() {
        System.out.println("This is the print information of Class B");
    }


    public static void main(String[] args) {
        ClassA classa = new ClassB();
        classa.printInformation();
    }

    public void sum(int x, int y) {
        System.out.println(x+y);
    }
}
