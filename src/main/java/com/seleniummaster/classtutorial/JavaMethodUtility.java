package com.seleniummaster.classtutorial;

public class JavaMethodUtility {
    public static void main(String[] args) {
        JavaMethodDemo Demo = new JavaMethodDemo();// create an instance or instantiate the object
        long l1 = Demo.addTwoNumbers(100, 300);
        System.out.println(l1);
        System.out.println(Demo.addTwoNumbers(500,600));

        int rect1 = Demo.calculateRectangleArea(10, 50);
        int rect2 = Demo.calculateRectangleArea(5, 6);
        int rect3 = Demo.calculateRectangleArea(8, 5);
        System.out.println(String.format("rect1=%d rect2=%d rect3=%d", rect1, rect2, rect3));

        // I want to calculate two circles with radius 20, 10
        double circle1 = Demo.calculateCircleArea(20);
        double circle2 = Demo.calculateCircleArea(10);
        double circle3 = Demo.calculateCircleArea(30);
        System.out.println(String.format("ciercle1=%.2f ciercle1=%.2f ciercle1=%.2f", circle1, circle2, circle3));

        int[] myNmubers = new int[]{4, 20, 56, 12, 14, 2, 5, 7, 8, 10, 25};
        int sum = Demo.sumOfNumbers(myNmubers);
        System.out.println(sum);
        System.out.println(Demo.sumOfNumbers(new int[]{1,5,19,21,99,100}));


        Person newPerson = Demo.addNewPerson("ahmed", "bughra", true);
        System.out.println(newPerson.toString());
        JavaMethodDemo.parseStringToLetter("Automation");
    }
}
