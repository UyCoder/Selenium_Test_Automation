package com.seleniummaster.sandbox;

public class CWAddNewClient {
    private String firstName;
    private String lastName;
    boolean gender;
    private String DOB;
    private int medicareNumber;
    private int privateHealthFund;
    private long phoneNumber;
    private String email;
    private String address;
    private String suburb;
    private int postCode;
    private String occupation;
    private String notes;

    public CWAddNewClient(String firstName, String lastName, Boolean gender,String DOB, int medicareNumber, int privateHealthFund,
                          long phoneNumber, String email, String address, String suburb, int postCode, String occupation, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender=gender;
        this.DOB = DOB;
        this.medicareNumber = medicareNumber;
        this.privateHealthFund = privateHealthFund;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.suburb = suburb;
        this.postCode = postCode;
        this.occupation = occupation;
        this.notes = notes;
    }
    public int getPrivateHealthFund() {
        return privateHealthFund;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

        public String getDOB() {
        return DOB;
    }

    public int getMedicareNumber() {
        return medicareNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSuburb() {
        return suburb;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getNotes() {
        return notes;
    }
}
