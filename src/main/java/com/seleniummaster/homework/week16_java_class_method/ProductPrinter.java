package com.seleniummaster.homework.week16_java_class_method;

import java.sql.PreparedStatement;

public class ProductPrinter {
    public static void main(String[] args) {
        //make a new product
        Product laptop1= new Product();
        laptop1.name = "Dell Precision 5000";
        laptop1.category = "Windows PC";
        laptop1.price = 599.99;

        // make another product
        Product laptop2 = new Product();
        laptop2.name = "HP Pavilion 14";
        laptop2.category = "Windows PC";
        laptop2.price = 529.99;

        //print name, category, price
        //reduces their prices by $50, and then prints the prices again
        System.out.println("==========[ "+laptop1.name+" ]===========");
        System.out.println("Category: "+laptop1.category);
        System.out.println("Price: "+laptop1.price);
        System.out.println("Price after reduce: "+laptop1.reducePrice(50.00));
        System.out.println();
        System.out.println("============[ "+laptop2.name+" ]==============");
        System.out.println("Category: "+laptop2.category);
        System.out.println("Price: "+laptop2.price);
        System.out.println("Price after increse: "+laptop2.increasePrice(50.00));
  }
}
