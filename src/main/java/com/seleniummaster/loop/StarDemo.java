package com.seleniummaster.loop;

public class StarDemo {
    public static void main(String[] args) {
        // print a trianle with the * symbol
        for (int row=1; row<=5;row++)
        {
            for (int column=1; column<=row;column++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
