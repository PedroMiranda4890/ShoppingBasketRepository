package com.interview.shoppingbasket;

import java.util.List;

class CheckoutContext {
    private Basket basket;
    private double retailPriceTotal = 0.0;
    List<Promotion> list_prom;

    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    CheckoutContext(Basket basket) {
        this.basket = basket;
    }

    public List<Promotion> getPromotions(){
        return this.list_prom;
    }

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }

    public void addPromotion(List<Promotion> l_p){
        this.list_prom = l_p;
    }

    public Basket getBasket() {
        return basket;
    }
}
