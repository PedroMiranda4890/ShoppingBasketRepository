package com.interview.shoppingbasket;

public class PromotionFifty extends Promotion{

    public PromotionFifty(String pc) {
        super(pc);
    }

    @Override 
    public double aplicaPromotion(double price, int quantity){
        
        /*precoWithPromotion = price**/
        return price*0.5;

    }
}