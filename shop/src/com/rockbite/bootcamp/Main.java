package com.rockbite.bootcamp;

public class Main {

    public static void main (String[] args) {

        // Initializing Shop object
        Shop shop = new Shop();

        // Initializing 3 different products, and specifying their categories
        shop.addProduct(new Product(1, "Gem"), ShopCategory.BASIC);
        shop.addProduct(new Product(2, "Chocolate"), ShopCategory.BASIC);
        shop.addProduct(new Product(3, "Romantic Pack"), ShopCategory.OFFERS);

        // configuring cost and payload for product 1
        shop.getProduct(1).setPayload(ItemLibrary.GEM.get(), 1);
        shop.getProduct(1).setCost(ItemLibrary.CREDIT.get(), 10);

        // configuring cost and payload for product 2
        shop.getProduct(2).setPayload(ItemLibrary.CHOCOLATE.get(), 1);
        shop.getProduct(2).setCost(ItemLibrary.CREDIT.get(), 10);

        // configuring cost and payload for product 3
        shop.getProduct(3).setPayload(ItemLibrary.LUBE.get(), 1);
        shop.getProduct(3).setPayload(ItemLibrary.CHOCOLATE.get(), 1);
        shop.getProduct(3).setCost(ItemLibrary.GEM.get(), 2);

        // Initializing the player
        Player player = new Player();

        // Player has some initial credits
        player.addItem(ItemLibrary.CREDIT.get(), 2000);

        // outputting player inventory
        player.outputInventory();

        // lets see if we can purchase product number 3, the romantic pack, we should not be able to since player has no gems
        if (shop.canAfford(player, 3)) {
            shop.transaction(player, 3);
        } else {
            System.out.println("player can't afford: " + shop.getProduct(3));
        }

        // to purchase missing 2 gems we need to purchase product number 1 - 2 times
        for(int i = 0; i < 2; i++) {
            shop.transaction(player, 1);
        }

        // outputting player inventory
        player.outputInventory();

        // lets' try to do the transaction again
        if (shop.canAfford(player, 3)) {
            shop.transaction(player, 3);
        } else {
            System.out.println("player can't afford: " + shop.getProduct(3));
        }

        // outputting player inventory, this time finally it should show that player has chocolate and lube in their inventory
        player.outputInventory();
    }
}
