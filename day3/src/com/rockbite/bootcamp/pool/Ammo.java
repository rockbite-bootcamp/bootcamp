package com.rockbite.bootcamp.pool;

public class Ammo implements Poolable {

    float x;
    float y;

    float velocity;

    @Override
    public void reset () {
        x = 0;
        y = 0;
        velocity = 0;
    }
}
