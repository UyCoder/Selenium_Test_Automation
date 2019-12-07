package com.seleniummaster.classtutorial;

public class ExceptionDemo1 {
    //checked exeption
    public static void main(String[] args)  {
        if (args.length>=1) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            try {
                float c = a / b;
                System.out.println("Division value:" + c);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }




        } else{
            System.out.println("Your din not input numbers.");

        }

        //wait 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time is up");

    }
}
