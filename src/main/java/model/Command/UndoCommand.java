package model.Command;

import model.interfaces.ICommand;

public class UndoCommand implements ICommand {

  @Override
  public void undo() {
    CommandHistory.undo();
  }

  @Override
  public void redo() {

  }
}

