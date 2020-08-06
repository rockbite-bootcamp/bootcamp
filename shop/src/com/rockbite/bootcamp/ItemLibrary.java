package com.rockbite.bootcamp;

/**
 * A generated list of possible items that are available in game
 * This is an ENUM that can be generated from some outside tool or editor
 */
public enum ItemLibrary {

    CREDIT (new Item("Credit")),
    GEM (new Item("Gem")),
    LUBE (new Item("Lube")),
    CHOCOLATE (new Item("Chocolate"));

    private final Item item;

    ItemLibrary(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.getName();
    }

    public Item get() {
        return item;
    }
}
