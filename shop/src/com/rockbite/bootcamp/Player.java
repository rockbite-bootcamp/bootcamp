package com.rockbite.bootcamp;

import java.util.HashMap;

/**
 * Player class that can hold player related data, but also implements InventoryProvider interface, since player has inventory
 */
public class Player implements InventoryProvider {

    private HashMap<Item,  Integer> inventory = new HashMap<>();

    public Player() {

    }

    @Override
    public boolean hasItem (Item item, int count) {
        if(!inventory.containsKey(item)) {
            return false;
        }

        return inventory.get(item) > 0;
    }

    @Override
    public void spendItem (Item item, int count) {
        if(!inventory.containsKey(item) || inventory.get(item) < count) {
            // Actually we should throw an exception here, but for the sake of example will just output
            System.out.println("Trying to spend item that we don't have enough of");
        }

        if(inventory.containsKey(item)) {
           int currCount = inventory.get(item);

            inventory.put(item, currCount - count);
        }
    }

    @Override
    public void addItem (Item item, int count) {
        if(!inventory.containsKey(item)) {
            inventory.put(item, count);
        } else {
            inventory.put(item, inventory.get(item) + count);
        }
    }

    public void outputInventory() {
        System.out.println("player inventory");
        System.out.println("---------------");

        for(Item item: inventory.keySet()) {
            int count = inventory.get(item);

            System.out.println(item.getName() + ": " + count);
        }

        System.out.println("---------------");
    }
}
