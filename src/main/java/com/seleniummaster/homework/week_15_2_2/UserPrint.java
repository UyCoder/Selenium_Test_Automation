package com.seleniummaster.homework.week_15_2_2;

public class UserPrint {
    public static void main(String[] args) {

        // Afer create a matin mathod, set the value for the constructor.
        User user1 = new User("Ahmed", "123456789", "Student", true);

        // Print all the elements from user1
        System.out.println(user1.getUserName());
        System.out.println(user1.getPassword());
        System.out.println(user1.getRole());
        System.out.println(user1.isAvtive());

        //we can use this after generate toString on constructor
        System.out.println(user1.toString());

    }
}
