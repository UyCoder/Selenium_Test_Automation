package com.seleniummaster.classtutorial;

public class Calculator {

    // method overloading
    public int addNumbers(int a, int b) {
        return a + b;
    }

    public double addNumbers(double d1, double d2) {
        return d1 + d2;
    }

    public int addNumbers(long l1, long l2) {
        return (int) (l1 + l2);
    }

    public long addNumbers(long l1, long l2 , long l3) {
        return l1 +l2 +l3;
    }

    public long addNumbers(long... longs) {
        long sum = 0;
        for (long l : longs) {
            sum = l + sum;
        }
        return sum;
    }

}
