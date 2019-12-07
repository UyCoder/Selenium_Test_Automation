package com.seleniummaster.inheritancetutorial;

public class StudentInformation {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFirstName("abc");
        student1.setLastName("Def");
        System.out.println(student1.toString());

        GraduateStudent graduateStudent1 = new GraduateStudent();
        graduateStudent1.setFirstName("Danny");
        graduateStudent1.setLastName("Mike");
        graduateStudent1.setMiddleInitial("A");
        graduateStudent1.setMajor("Test Automation");
        graduateStudent1.setGender("Male");
        graduateStudent1.setClassName("United Coder SDET");
        graduateStudent1.setAdvisorName("Dolkun");
        graduateStudent1.setResearchField("Test Automation");
        System.out.println(graduateStudent1.toString());
    }
}
