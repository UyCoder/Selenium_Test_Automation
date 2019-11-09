package com.seleniummaster.datatype;

public class StringDemo2 {
    public static void main(String[] args) {
        //compare two strings
        String s1="Hello";
        String s2="hello";
        System.out.println(s1.equals(s2));
        System.out.println(s2.equalsIgnoreCase(s2));
        System.out.println(s1.equals("Hello"));

        //concatenate string together
        String s3="Selenium Test Auotomation";
        System.out.println(s1+","+s3);
        System.out.println(s1.concat(",").concat(s3));
        System.out.println(String.format("%s,%s",s1,s3));

        //replace string (convert "selenium test automation" to "Java test automation")
        System.out.println(s3.replace("Selenium","Java"));

    }
}
