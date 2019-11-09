package com.seleniummaster.basic.homework;

public class Week13_1_7 {
    public static void main(String[] args) {
        String name1 = "Selenium";
        String name2 = "selenium";
        if (name1.equalsIgnoreCase(name2))
            System.out.println(name1);
        else
            System.out.println(name2);
    }
}
