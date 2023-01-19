package com.interview.shoppingbasket;

public class Promotion21 extends Promotion{


    public Promotion21(String pc) {
        super(pc);
    }

    @Override 
    public double aplicaPromotion(double price, int quantity){

        /*precoWithPromotion = price**/
        if(quantity%2==0){
           return price*0.5;
        }else{
            return price*(0.6);
        }

    }

    
    
}
