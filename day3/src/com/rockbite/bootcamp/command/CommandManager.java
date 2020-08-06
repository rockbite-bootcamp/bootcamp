package com.rockbite.bootcamp.command;

import com.rockbite.bootcamp.pool.Pool;

import java.util.ArrayList;

public class CommandManager {

    ArrayList<Command> history = new ArrayList<>();

    private int cursor = 0;

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

    public void executeCommand(Command command) {
        command.execute();

        if (cursor < history.size()) {
            history.set(cursor, command);
        } else {
            history.add(command);
        }

        cursor++;
    }

    public void undo() {
        if(cursor == 0) return;

        Command command = history.get(cursor - 1);
        command.undo();

        cursor--;
    }

    public void redo() {
        if(cursor > history.size() - 1) return;

        Command command = history.get(cursor);
        command.execute();
        cursor++;
    }
}
