package com.seleniummaster.week19;

public class PromotionalCode {
    private String code;
    private String description;
    private DiscountType discountType;
    private String discountValue;
    private String expires;
    private boolean discountAppliesToShippingCost;
    public PromotionalCode() {
    }

    public PromotionalCode(String code, String description, DiscountType discountType,
                           String discountValue, String expires,
                           boolean discountAppliesToShippingCost) {
        this.code = code;
        this.description = description;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.expires = expires;
        this.discountAppliesToShippingCost = discountAppliesToShippingCost;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public String getExpires() {
        return expires;
    }

    public boolean isDiscountAppliesToShippingCost() {
        return discountAppliesToShippingCost;
    }

    @Override
    public String toString() {
       return String.format("%s,%s,%s,%s,%s,%s",code,description,discountType.name(),
               discountValue,expires,String.valueOf(discountAppliesToShippingCost));
    }
}
