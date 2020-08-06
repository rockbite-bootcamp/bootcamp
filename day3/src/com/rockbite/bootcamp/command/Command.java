package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.pool.Poolable;

public interface Command extends Poolable {

    void execute();

    void undo();

}
