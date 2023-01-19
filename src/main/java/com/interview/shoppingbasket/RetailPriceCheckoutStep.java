package com.interview.shoppingbasket;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
        
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;


        for (BasketItem basketItem: basket.getItems()) {
           

            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
            System.out.println("RECEBEquantity" + quantity);
            System.out.println("RECEBEprice   " + price);
            for(Promotion promotion: checkoutContext.getPromotions()) {
                
                price = applyPromotion(promotion, basketItem, price);
                System.out.println("AfterPromotionPRICE   " + price);
                //retailTotal = retailTotal+quantity*price;
            }
            basketItem.setProductRetailPrice(price);
            
            //retailTotal += price;
            //retailTotal = retailTotal + price;
        
            retailTotal = retailTotal + quantity*price;
            /*System.out.println("TOTAL " + retailTotal);
            retailTotal = retailTotal + price;
            System.out.println("TOTAL " + retailTotal);*/
        }

        System.out.println(retailTotal);

        //System.out.println("TOTAL " + retailTotal);
        checkoutContext.setRetailPriceTotal(retailTotal);
        
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        /*
         * Implement applyPromotion method
         * 
         *
         */
        double retailTotal1;
         
        if (promotion.doPromotion(item)) {
            
            retailTotal1 = promotion.aplicaPromotion(price, item.getQuantity());
        }else{
            retailTotal1 = price;
        }
        
        //System.out.println("AP - Retail Total   " + retailTotal);
        return retailTotal1;
    }
}

