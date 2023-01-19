
package com.interview.shoppingbasket;

public class PromotionTen extends Promotion{

    public PromotionTen(String pc) {
        super(pc);
    }

    @Override 
    public double aplicaPromotion(double price, int quantity){
        
        /*precoWithPromotion = price**/
        return price-price*0.1;

    }
}
