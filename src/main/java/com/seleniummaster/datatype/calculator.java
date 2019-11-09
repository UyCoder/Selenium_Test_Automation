package com.seleniummaster.datatype;

public class calculator {
    public static void main(String[] args) {
        /**Write a claculator program to calculate +, -, * and / of two numbers
         * Please pass the numbers and operators as arguments
         * this jar file will runs well when you type like this:
         * java -jar <jar-file-name> <n1> <n2> <+, -, * or />
         */
        if(args.length<3)
        {
            System.out.println("Please enter 3 argument...");
        }
        else {
            double number1=Double.parseDouble(args[0]);
            double number2=Double.parseDouble(args[1]);
            if(args[2].equalsIgnoreCase("+"))
                System.out.println(String.format("%f + %f = %f",number1,number2,number1+number2));
            else if(args[2].equalsIgnoreCase("-"))
                System.out.println(String.format("%f - %f = %f",number1,number2,number1-number2));
            else if (args[2].equalsIgnoreCase("/"))
                System.out.println(String.format("%f / %f = %f",number1,number2,(float)number1/number2));
            else

            System.out.println(String.format("%f * %f = %f",number1,number2,number1*number2));
        }
    }
}
