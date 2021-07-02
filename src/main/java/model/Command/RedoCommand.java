package model.Command;

import model.interfaces.ICommand;

public class RedoCommand implements ICommand {
    @Override
    public void run() {

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {
        CommandHistory.redo();
    }
}
