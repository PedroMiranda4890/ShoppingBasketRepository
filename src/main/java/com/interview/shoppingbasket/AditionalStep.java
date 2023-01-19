package com.interview.shoppingbasket;

import java.util.List;

public class AditionalStep implements CheckoutStep {

        private PromotionsService promotionService;
    
        private List<Promotion> list_prom;

       
    
        public AditionalStep(PromotionsService pService) {
            this.promotionService =  pService;
            //this.pricingService = pricingService;
        }

        @Override
        public void execute(CheckoutContext checkoutContext) {
            
            Basket basket = checkoutContext.getBasket();
            list_prom = this.promotionService.getPromotions(basket);

           
            //Add promotions to context
            checkoutContext.addPromotion(list_prom); 
            

            
        }
    
       
    }
    


