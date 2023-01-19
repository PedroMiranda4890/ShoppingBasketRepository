package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CheckoutPipelineTest {

    //meu
    

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    @Mock
    CheckoutStep checkoutStep2;

    @BeforeEach
    void setup() {
        checkoutPipeline = new CheckoutPipeline();
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        
        // Exercise - implement testing passing through all checkout steps
        Basket basket = new Basket();
        basket.add("productCode1", "productName1",2);
        basket.add("productCode2", "productName2",5);
        basket.add("productCode1", "productName1",2);

        basket.consolidateItems();

        List<Promotion> list = new ArrayList<>();
        Promotion p1 = new PromotionFifty("productCode1");
        list.add(p1);
        Promotion p2 = new PromotionTen("productCode2");
        list.add(p2);


        PromotionsService promotionService = mock(PromotionsService.class);
        PricingService pricingService = mock(PricingService.class);

        BasketConsolidationCheckoutStep consolidate = new BasketConsolidationCheckoutStep();
        AditionalStep promotionCheckoutStep = new AditionalStep(promotionService);
        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);

        checkoutPipeline.addStep(consolidate);
        checkoutPipeline.addStep(promotionCheckoutStep);
        checkoutPipeline.addStep(retailPriceCheckoutStep);

        when(promotionService.getPromotions(basket)).thenReturn(list);
        when(pricingService.getPrice("productCode1")).thenReturn(10.0);
        when(pricingService.getPrice("productCode2")).thenReturn(5.0);

        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        double expectedRetailTotal = 42.5;
        assertEquals(paymentSummary.getRetailTotal(), expectedRetailTotal);
       
    }

}
