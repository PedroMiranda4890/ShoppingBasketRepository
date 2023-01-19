package com.interview.shoppingbasket;

public abstract class Promotion {
   
    private String productCode;

    public Promotion(String pc){
        this.productCode = pc;
    }

    public abstract double aplicaPromotion(double price, int quantity);    

    public boolean doPromotion(BasketItem item) {
        
        return item.getProductCode().equals(productCode);
        
    }

    public String getProductCode(){
        return this.productCode;
    }
}
