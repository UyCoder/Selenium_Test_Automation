package com.seleniummaster.interfacetutorial;

public class Calculator implements ISimpleCalculator, IScientificCalculator{

    @Override
    public double addTwoNumber(double a, double b) {
        double sum=a+b;
        System.out.println(String.format("%.2f + %.2f = %.2f", a, b, sum));
        return sum;
    }

    @Override
    public int multiplyTwoNumber(int i1, int i2) {
        int result=i1*i2;
        System.out.println(String.format("%d * %d = %d", i1, i2, result));
        return result;
    }

    @Override
    public long subTrackTwoNumber(long l1, long l2) {
        System.out.println(String.format("%d - %d = %d", l1, l2, l1 - l2));
        return l1-l2;
    }

    @Override
    public double divideTwoNumber(double d1, double d2) {
        if (d2 != 0) {
            float result = (float) (d1 / d2);
            System.out.println(String.format("%.2f divide by %.2f is %.2f",d1,d2,result));
            return result;
        } else {
            System.out.println("Your denominator is zero");
            return 0;
        }
    }

    @Override
    public double calculatePower(int base, int power) {
        double r = Math.pow(base, power);
        System.out.println(String.format("%d to the power of %d = %.2f",base,power,r));
        return r;
    }

    @Override
    public double calculateSquareRoor(long l1) {
        double s = Math.sqrt(l1);
        System.out.println(String.format("%d Square Root is %.2f", l1, s));
        return s;
    }

    @Override
    public double calculateAbstractValvue(int x) {
        double abs = Math.abs(x);
        System.out.println(String.format("Abstract value of %d is %.2f", x, abs));
        return abs;
    }
}
