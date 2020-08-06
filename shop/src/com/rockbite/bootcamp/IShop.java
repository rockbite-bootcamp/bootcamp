package com.rockbite.bootcamp;

import java.util.HashMap;

/**
 * Interface for any in game shop that can list it's products, find product list by category and perform transactions
 * @author azakhary
 */
public interface IShop {

    /**
     * Get product list for specific category
     *
     * @param category
     * @return
     */
    HashMap<Integer, Product> getProducts (ShopCategory category);

    /**
     * Returns product by SKU
     * @param SKU
     * @return
     */
    Product getProduct (int SKU);

    /**
     * perform check for particular SKU with provided inventory provider to see if it can be transacted
     *
     * @param player
     * @param SKU
     * @return
     */
    boolean canAfford (InventoryProvider player, int SKU);

    /**
     * perform transaction for particular SKU with provided inventory provider
     *
     * @param inventoryProvider
     * @param SKU
     * @return
     */
    boolean transaction (InventoryProvider inventoryProvider, int SKU);
}
