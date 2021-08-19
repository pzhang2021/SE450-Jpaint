package model.Command;

import java.util.Stack;
import model.GroupShape;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class GroupCommand implements ICommand {
  ShapeList shapeList;
  GroupShape groupShape;
  public GroupCommand(ShapeList shapeList) {
    this.shapeList = shapeList;
  }

  public void run() {
    groupShape = new GroupShape(shapeList);
    groupShape.makeGroup();
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    groupShape.undoGroup();
  }

  @Override
  public void redo() {
    groupShape.redoGroup();
  }
}
