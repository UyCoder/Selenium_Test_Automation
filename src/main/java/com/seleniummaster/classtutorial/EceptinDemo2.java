package com.seleniummaster.classtutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

public class EceptinDemo2 {
    // we write a text file on a disk using the object  PrintWriter
    public static void main(String[] args) {

        if (args.length>=1) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            try {
                float c = a / b;
                System.out.println("Division value:" + c);
            } catch (ArithmeticException e) {
                File file = new File("error" + System.currentTimeMillis() + ".txt");
                Writer out;
                PrintWriter writer= null;
                try {
                    writer = new PrintWriter(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                writer.print(e.getMessage());
                writer.close();
            }
        } else{
            System.out.println("Your din not input numbers.");
        }
    }
}
