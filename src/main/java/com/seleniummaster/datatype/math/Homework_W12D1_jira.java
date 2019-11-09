package com.seleniummaster.datatype.math;

public class Homework_W12D1_jira {
    public static void main(String[] args) {
        // 1.combine school name, address, and zip code together and store it with a String variable named "schoolFullAddress".
        String SchoolName="School name: The China University of Petroleum" ;
        String Address="Address: Qingdao Economic and Technological Development Zone, Shandong";
        String ZipCode="ZipCode: 266555";
        String schoolFullAddress= SchoolName + Address + ZipCode;

        // 2.print school name with all Capital letters.
        System.out.println(SchoolName.toUpperCase());

        // 3.print school address with all lower case letters.
        System.out.println(Address.toLowerCase());

        // 4.from schoolFullAddress, print out only the zip code.
        System.out.println(schoolFullAddress.substring(125,131));

        // 5.print out total length of the schoolFullAddress String variable.
        System.out.println(schoolFullAddress.length());

        // 6.print out the result if your school name equals ot "University".
        System.out.println(SchoolName.contains("University"));

        // 7.print out the result if your school name contains a char 'S'.
        System.out.println(SchoolName.contains("S"));

        // 8.Use String.format to print out your school full address.
        System.out.println(String.format(" %s\n %s \n %s\n",SchoolName, Address, ZipCode));
    }
}

