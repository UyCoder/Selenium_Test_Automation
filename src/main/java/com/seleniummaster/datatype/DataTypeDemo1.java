package com.seleniummaster.datatype;

public class DataTypeDemo1 {
    public static void main(String[] args) {
        //we'll learn byte, short, int, long, double, float, boolean, char

        //byte and byte operations ('byte' use in eletronic system)
        //seearch google "Java bitwise " if you don't understand AND operation
        byte a = 111;
        byte b = 110;
        byte c = (byte) (a & b);
        byte d = (byte) (a | b);
        System.out.println("This is AND operation  " + c);
        System.out.println("This is OR operation  " + d);

        //short Demo
        short s1 = 3500;
        short s2 = 6000;
        System.out.println(s1 + s2);
        short s3 = 32767;
        System.out.println("Range of 'short' DataType in Java is " + s3);
        System.out.println("Rage of port number is " + s3 * 2);
        System.out.println(String.format("%d + %d = %d", s1, s2, s3));

        //int Demo
        int i1 = 10000000;
        int i2 = 20000000;
        //operations : +, -, /, * ... google search "format specifiers Java"
        System.out.println(String.format("%d + %d = %d", i1, i2, i1 + i2));
        System.out.println(String.format("%d - %d = %d", i2, i1, i2 - i1));
        System.out.println(String.format("%d / %d = %f", i1, i2, (double) i1 / i2));
        System.out.println(String.format("%d * %d = %d", i1, i2, i1 * i2));

        //long daya type
        long x = 12345678901234567L;
        long y = 897654321145658980L;
        long z = x + y;
        System.out.println(String.format("%d + %d = %d", x, y, z));

        //float data type
        float f1 = 3.1415f;
        float f2 = 2.546789f;
        float f3 = f1 + f2;
        String result = String.format("%f + %f = %f", f1, f2, f3);
        System.out.println(result);
        //only get 2 precision of the result
        System.out.println(String.format("%f + %f = %.2f", f1, f2, f3));

        //double data type
        double d1 = 100.09;
        double d2 = 2000.10;
        double d3 = d1 + d2;
        double d4 = d / d2;
        System.out.println(String.format("%.2f + %.2f = %.2f", d1, d2, d3));
        System.out.println(String.format("%.2f / %.2f = %.2f", d1, d2, d4));

        //boolean data type
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = false;
        //in boolen datatype only two operations. 1.and &&   2.or ||
        System.out.println(String.format("%b AND %b = %b", b1, b2, b1 && b2));
        System.out.println(String.format("%b OR %b = %b", b1, b3, b1 || b3));


    }
}
