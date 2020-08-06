package com.rockbite.bootcamp;

import java.util.HashMap;

/**
 * In game shop with list of it's products
 */
public class Shop implements IShop {

    /**
     * Quick lookup map so that we can easily find products by category
     */
    private HashMap<ShopCategory, HashMap<Integer, Product>> categoryMap = new HashMap<>();

    /**
     * List of all products for looking up by SKU, without caring about category
     */
    private HashMap<Integer, Product> productMap = new HashMap<>();

    /**
     * Adds a product to the list of this shop products that are available for sale
     * @param product
     * @param category
     */
    public void addProduct(Product product, ShopCategory category) {
        productMap.put(product.getSKU(), product);

        if(!categoryMap.containsKey(category)) {
            categoryMap.put(category, new HashMap<>());
        }

        categoryMap.get(category).put(product.getSKU(), product);
    }

    @Override
    public HashMap<Integer, Product> getProducts(ShopCategory category) {
        return categoryMap.get(category);
    }

    @Override
    public Product getProduct (int SKU) {
        return productMap.get(SKU);
    }

    /**
     * Inventory provider can afford a product, if ALL of its costs can be afforded on their own
     *
     * @param inventoryProvider
     * @param SKU
     * @return
     */
    @Override
    public boolean canAfford (InventoryProvider inventoryProvider, int SKU) {
        Product product = productMap.get(SKU);

        if (product == null) return false;

        for (Item item: product.getCost().keySet()) {
            int count = product.getCost().get(item);
            if (!inventoryProvider.hasItem(item, count)) {
                return false;
            }
        }

        return true;
    }

    /**
     * this transaction will find a product, and if it exists check if inventory provider can afford it
     * If it can be afforded within this transaction the cost will be spent, and payloads will be rewarded.
     *
     * @param inventoryProvider
     * @param SKU
     * @return true, if transaction was successful
     */
    @Override
    public boolean transaction (InventoryProvider inventoryProvider, int SKU) {

        Product product = productMap.get(SKU);

        if (product != null) {

            if (canAfford(inventoryProvider, SKU)) {
                for(Item item: product.getCost().keySet()) {
                    int count = product.getCost().get(item);
                    inventoryProvider.spendItem(item, count);
                }

                for (Item item: product.getPayload().keySet()) {
                    int count = product.getPayload().get(item);
                    inventoryProvider.addItem(item, count);
                }

                System.out.println("transaction complete for product: " + product.getProductName());

                return true;
            }
        }

        return false;
    }
}
