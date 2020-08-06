package com.rockbite.bootcamp;

/**
 * Any object that can also act as a provider of inventory must implement this interface
 * In order to provide accessibility to it's items
 *
 * Possible use cases include Players or other types of inventory holders
 */
public interface InventoryProvider {

    boolean hasItem (Item item, int count);

    void spendItem (Item item, int count);

    void addItem (Item item, int count);

}
