package com.interview.shoppingbasket;

import lombok.Data;

@Data
public class BasketItem {
    private String productCode;
    private String productName;
    private int quantity;
    private double productRetailPrice;
   
    //GETS
    public String getProductCode(){
        return this.productCode;
    }

    public String getProductName(){
        return this.productName;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getProductRetailPrice(){
        return productRetailPrice;
    }

    //SETS
    public void setProductCode(String pc){
        this.productCode = pc;
    }

    public void setProductName(String pn){
        this.productName = pn;
    }

    public void setQuantity(int quant){
        this.quantity = quant;
    }

    public void setProductRetailPrice(double retailPrice){
        this.productRetailPrice = retailPrice;
    }
    
}
