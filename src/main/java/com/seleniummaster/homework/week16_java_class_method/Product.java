package com.seleniummaster.homework.week16_java_class_method;

public class Product {
     String name;
     String category;
     double price;


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double reducePrice(double reduce){
        double reducedPrice= price - reduce;
        return reducedPrice;
    }

    public double increasePrice(double increase){
        double increasedPrice= price + increase;
        return increasedPrice;
    }
}

