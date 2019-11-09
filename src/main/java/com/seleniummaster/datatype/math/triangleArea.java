package com.seleniummaster.datatype.math;

public class triangleArea {
    public static void main(String[] args) {
        TriangleArea(2,3);
        String bar="\u0628\u0627\u0631";
        System.out.println(bar);
    }
    private static void TriangleArea(int a, int h) {
        float area = (float) (a*h)/2;
        System.out.println(String.format("(%d + %d) / 2 = %.2f",a,h,area));
    }
}
