package com.seleniummaster.classtutorial;

public class Student {
    private String firstName;
    private String lastName;
    // create constuctor
    public Student() {

    }
    public Student(String firstName) {
        this.firstName=firstName;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override // we can remove this line
    // when we make the toString we can unselect sensitive variables
    public String toString() {
        return "FirstName=" + firstName + ", lastName=" + lastName;
    }
}
