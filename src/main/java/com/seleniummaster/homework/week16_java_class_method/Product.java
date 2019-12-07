package com.seleniummaster.homework.week16_java_class_method;

public class Product {
     // declare variable
     String name;
     String category;
     double price;

    //generate getter method
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    // made public method reducePrice() and increasePrice()
    public double reducePrice(double reduce){
        double reducedPrice= price - reduce;
        return reducedPrice;
    }

    public double increasePrice(double increase){
        double increasedPrice= price + increase;
        return increasedPrice;
    }
}

