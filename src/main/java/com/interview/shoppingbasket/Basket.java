package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        Map<String, BasketItem> Items_Temp = new HashMap<>();
        for (BasketItem item : items) {
            if (Items_Temp.containsKey(item.getProductCode())) {
                BasketItem consolidatedItem = Items_Temp.get(item.getProductCode());
                consolidatedItem.setQuantity(consolidatedItem.getQuantity() + item.getQuantity());
                consolidatedItem.setProductName(item.getProductName());
            } else {
                BasketItem consolidatedItem = new BasketItem();
                consolidatedItem.setProductCode(item.getProductCode());
                consolidatedItem.setProductName(item.getProductName());
                consolidatedItem.setQuantity(item.getQuantity());
                Items_Temp.put(item.getProductCode(), consolidatedItem);
            }
        }
        items.clear();
        for (Map.Entry<String, BasketItem> entry : Items_Temp.entrySet()) {
            BasketItem newItem = new BasketItem();
            newItem.setProductCode(entry.getKey());
            newItem.setProductName(entry.getValue().getProductName());
            newItem.setQuantity(entry.getValue().getQuantity());
            items.add(newItem);
        }
    }

    

   
}
