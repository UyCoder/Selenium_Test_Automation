package com.seleniummaster.week19;

public enum DiscountType {
    Fixed_Price_Discount("Fixed Price Discount"),
    Percentage_Discount("Percentage Discount");
    private String option;
  DiscountType(String option)
    {
        this.option=option;
    }
    public String getOption()
    {
        return this.option;
    }


}
