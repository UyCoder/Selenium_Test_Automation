package com.seleniummaster.datatype;

import java.util.Scanner;

public class AddressInputDemo {
    public static void main(String[] args) {
        //write a program to print out your full adress on the screen
        //System asks yoou to input street name, house number, city, state, and zipcode
        //then you print out your full address
        Scanner input=new Scanner(System.in);

        System.out.println("Please enter your Street name:");
        String StreetName= input.nextLine();
        System.out.println("Please enter House number:");
        String HouseNumber= input.nextLine();
        System.out.println("Please enter your city:");
        String city= input.nextLine();
        System.out.println("Please enter your country name:");
        String State= input.nextLine();
        System.out.println("Please enter zip code?");
        int zip= input.nextInt();
        System.out.println();
        System.out.println("====================");
        System.out.println("Your full address is");
        System.out.println("====================");
        System.out.println(StreetName+" "+HouseNumber+" "+city+" "+State+" zipcode:"+zip);
    }
}
