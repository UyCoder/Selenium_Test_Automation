package com.seleniummaster.cubecart;

public class Product {
    private String productName;
    private ProductCondition productCondition;
    private String productCode;
    private int stockLevel;
    // generate default constructor
    public Product() {
    }
    // genrate constructor with attribute
    public Product(String productName, ProductCondition productCondition, String productCode, int stockLevel) {
        this.productName = productName;
        this.productCondition = productCondition;
        this.productCode = productCode;
        this.stockLevel = stockLevel;
    }

    // generate getter method
    public String getProductName() {
        return productName;
    }

    public ProductCondition getProductCondition() {
        return productCondition;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getStockLevel() {
        return stockLevel;
    }
}
