package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.singleton.Counter;

public class IncrementCommand implements Command {

    @Override
    public void execute () {
        Counter.getInstance().increment();
    }

    @Override
    public void undo () {
        Counter.getInstance().decrement();
    }

    @Override
    public void reset () {

    }
}
