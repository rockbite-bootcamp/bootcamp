package com.rockbite.bootcamp.singleton;

public class Counter {

    private static Counter instance;

    private int counter = 0;

    private Counter() {

    }

    public static Counter getInstance() {

        if (instance == null) {
            instance = new Counter();
        }

        return instance;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int get() {
        return counter;
    }

}
