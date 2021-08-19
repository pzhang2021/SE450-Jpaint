package model.Command;

import model.MovementAlert;
import model.ShapeList;
import model.TwoPoint;
import model.interfaces.ICommand;
import model.interfaces.IStrategy;

/**
 * The main purpose of MoveCommand is to update new coordinate to all observers
 */
public class MoveCommand implements IStrategy, ICommand {

  private TwoPoint twoPoint;
  private ShapeList shapeList;

  MovementAlert movementAlert;

  public MoveCommand(TwoPoint twoPoint, ShapeList shapeList) {
    this.twoPoint = twoPoint;
    this.shapeList = shapeList;
  }

  @Override
  public void run() {
    movementAlert = new MovementAlert(shapeList);
    movementAlert.addMovement(twoPoint);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    if (shapeList.getMovementList().isEmpty()) {
      return;
    }
    movementAlert.undoMove();
  }

  @Override
  public void redo() {
    if (shapeList.getUndoRedoMovementList().isEmpty()) {
      return;
    }
    movementAlert.redoMove();
  }
}
