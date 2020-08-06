package com.rockbite.bootcamp;

/**
 * A data holder for an in game item, that only knows it's name and nothing more
 */
public class Item {

    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
