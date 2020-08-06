package com.rockbite.bootcamp;

import java.util.HashMap;

/**
 * A data holder for a product
 */
public class Product {

    /**
     * Unique SKU for this product cannot be changed and must be unique across the universe, and it's Shop's duty to enforce that
     */
    private final int SKU;

    /**
     * A nice name for product, since product can have multiple payloads
     */
    private final String productName;

    /**
     * Payloads is a map of items and their counts that will be REWARDED as part of transaction from inventory provider
     */
    private HashMap<Item,  Integer> payload = new HashMap<>();

    /**
     * Cost is a map of items and their counts that will be DEDUCED as part of transaction from inventory provider
     */
    private HashMap<Item,  Integer> cost = new HashMap<>();

    public Product(int SKU, String productName) {
        this.SKU = SKU;
        this.productName = productName;
    }

    public void clearPayload() {
        payload.clear();
    }

    public void clearCost() {
        cost.clear();
    }

    public void setPayload(Item item, int count) {
        payload.put(item, count);
    }

    public void setCost(Item item, int count) {
        cost.put(item, count);
    }

    public int getSKU() {
        return SKU;
    }

    public String getProductName() {
        return productName;
    }

    public HashMap<Item,  Integer> getPayload() {
        return payload;
    }

    public HashMap<Item,  Integer> getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return productName;
    }
}
