package com.seleniummaster.classtutorial.packageb;

import com.seleniummaster.classtutorial.packagea.Student;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirsName("James");
        student.setLastName("Bond");
        student.setGender("Male");
        System.out.println(student.getFirsName());
        System.out.println(student.getLastName());
        System.out.println(student.getGender());
    }
}
