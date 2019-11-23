package com.seleniummaster.classtutorial;

public class SchoolDemo {
    public static void main(String[] args) {
        School mySchool = new School();
        mySchool.setName("United Coder");
        mySchool.setLocation("Columbia, MD");
        mySchool.setType("Prefessional Engineering");
        System.out.println(mySchool.getName());
        System.out.println(mySchool.getLocation());
        System.out.println(mySchool.getType());

        School.Department department = new School.Department();
        department.setDepartmentName("Engineering");
        System.out.println(department.getDepartmentName());
    }
}
