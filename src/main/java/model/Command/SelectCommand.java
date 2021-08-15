package model.Command;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

import java.util.Stack;

/**
 * The main purpose of SelectCommand is to add observer (selected shape(s) are all observer) for
 * observer pattern
 */
public class SelectCommand implements IStrategy, ICommand {

  private TwoPoint twoPoint;
  private ShapeList shapeList;
  MovementAlert movementAlert;
  private Stack<Stack<IShape>> mySelectList;
  private Stack<Stack<IShape>> myUndoRedoList;

  public SelectCommand(TwoPoint twoPoint, ShapeList shapeList) {
    this.twoPoint = twoPoint;
    this.shapeList = shapeList;
  }

  @Override
  public void run() {
    mySelectList = shapeList.getSelectList();
    myUndoRedoList = shapeList.getUndoRedoSelectList();
    movementAlert = new MovementAlert();
    movementAlert.addObserver(shapeList, twoPoint);
    movementAlert.updateCurrentObserver(shapeList);
    CommandHistory.add(this);
    //System.out.println("There are " + mySelectList.lastElement().size() + " shape(s) selected");
  }

  @Override
  public void undo() {
    if (mySelectList.isEmpty()) {
      return;
    }
    myUndoRedoList.add(mySelectList.pop());
    movementAlert.updateCurrentObserver(shapeList);
    //System.out.println("There are " + mySelectList.lastElement().size() + " shape(s) selected");
  }

  @Override
  public void redo() {
    if (myUndoRedoList.isEmpty()) {
      return;
    }
    mySelectList.add(myUndoRedoList.pop());
    movementAlert.updateCurrentObserver(shapeList);
    //System.out.println("There are " + mySelectList.lastElement().size() + " shape(s) selected");
  }
}
