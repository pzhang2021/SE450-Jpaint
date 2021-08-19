package model.Command;

import model.GroupShape;
import model.ShapeList;
import model.interfaces.ICommand;

public class UngroupCommand implements ICommand {
  ShapeList shapeList;
  GroupShape groupShape;
  public UngroupCommand(ShapeList shapeList) {
    this.shapeList = shapeList;
  }

  public void run() {
    groupShape = new GroupShape(shapeList);
    groupShape.removeFromGroup();
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    groupShape.undoRemove();
  }

  @Override
  public void redo() {
    groupShape.redoRemove();
  }
}
