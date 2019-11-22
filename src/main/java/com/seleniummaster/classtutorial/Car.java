package com.seleniummaster.classtutorial;

public class Car {
    private String make;
    private String model;
    private double price;
    private int mileage;
    private int year;
    private String bodyType;
    private String color;
    private boolean isUsed;
    private String engineType;
    private boolean isAutomatic;
    private int zipCode;

    public Car() {
    }

    public Car(String make, String model, String color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public Car(String make, String model, String color, int zipCode) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.zipCode = zipCode;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public String getEngineType() {
        return engineType;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", year=" + year +
                ", bodyType='" + bodyType + '\'' +
                ", color='" + color + '\'' +
                ", isUsed=" + isUsed +
                ", engineType='" + engineType + '\'' +
                ", isAutomatic=" + isAutomatic +
                ", zipCode=" + zipCode +
                '}';
    }
}
