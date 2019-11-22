package com.seleniummaster.loop;

//numbers that devided by 2,3,5...//
public class ForLoopContinuedDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i % 3 == 0 && i % 5 == 0) {
                System.out.print(i + ", ");
                continue;
            }
        }
    }
}
