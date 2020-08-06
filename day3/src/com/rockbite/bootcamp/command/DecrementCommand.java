package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.singleton.Counter;

public class DecrementCommand implements Command {

    @Override
    public void execute () {
        Counter.getInstance().decrement();
    }

    @Override
    public void undo () {
        Counter.getInstance().increment();
    }

    @Override
    public void reset () {

    }
}
