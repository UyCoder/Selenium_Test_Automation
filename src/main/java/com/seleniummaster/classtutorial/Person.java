package com.seleniummaster.classtutorial;

public class Person {
    private String firstName;
    private String lastName;
    private boolean isMale;

    public Person() {
    }

    public Person(String firstName, String lastName, boolean isMale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMale = isMale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}
