package com.rockbite.bootcamp;

import com.rockbite.bootcamp.command.CommandManager;
import com.rockbite.bootcamp.command.DecrementCommand;
import com.rockbite.bootcamp.command.IncrementCommand;
import com.rockbite.bootcamp.pool.Pool;
import com.rockbite.bootcamp.singleton.Counter;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        CommandManager commandManager = new CommandManager();

        Pool<IncrementCommand> incrementPool =  new Pool<IncrementCommand>() {
            @Override
            protected IncrementCommand newObject () {
                return new IncrementCommand();
            }
        };

        Pool<DecrementCommand> decrementCommand =  new Pool<DecrementCommand>() {
            @Override
            protected DecrementCommand newObject () {
                return new DecrementCommand();
            }
        };

        commandManager.executeCommand(incrementPool.obtain());
        commandManager.executeCommand(incrementPool.obtain());

        commandManager.undo();
        commandManager.redo();

        System.out.println(Counter.getInstance().get());

    }

}
