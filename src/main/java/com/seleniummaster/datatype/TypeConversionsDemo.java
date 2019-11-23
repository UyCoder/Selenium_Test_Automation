package com.seleniummaster.datatype;

import com.seleniummaster.classtutorial.School;

public class TypeConversionsDemo {
    public static void main(String[] args) {
        //widening casting
        //byte => short => int => long => double (Implicit conversion)
        int x1 = 100;
        long l1 = x1; //no casting (or conversion) is required
        System.out.println(String.format("x1=%d",x1));
        System.out.println(String.format("l1=%d",l1));
        double d1=l1;
        float f1=l1;
        System.out.println(String.format("f1=%f",f1));


        //narrowing casting
        //double => float => long => int => short => byte
        long x2=20961;
        int i2=(int)x2;  //type casting is required
        short s2 = (short) i2; //type casting is required
        System.out.println(String.format("x2=%d",x2));
        System.out.println(String.format("i2=%d",i2));
        System.out.println(String.format("s2=%d",s2));

        //convert numeric String to numbers
        String myNmabuer = "123456789";
        myNmabuer = myNmabuer.replace("S","");
        int i=123;

        //add myNumber to i
        /**Integer.parseInt();
         * Long.parseLong();
         * Double.parseDouble();*/
        int sum = i + Integer.parseInt(myNmabuer);//convert numeric string to integer
        System.out.println(sum);
        float f2=Float.valueOf(myNmabuer);
        System.out.println(f2);
        float f3=Float.parseFloat(myNmabuer);
        System.out.println(f3);
        double d2=Double.parseDouble(myNmabuer);
        System.out.println(d2);

        //convert number to string
        int x3 = 985;
        float f4 = (float) 489.1234;
        String x35String = String.valueOf(x3);
    }
}
