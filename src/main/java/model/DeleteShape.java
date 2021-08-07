package model;

import model.interfaces.IMovementObserver;
import model.interfaces.IShape;

import java.util.Stack;

public class DeleteShape {
    ShapeList shapeList;

    public DeleteShape(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public void delete() {
        if (shapeList.getSelectList().isEmpty()) return;
        for(IMovementObserver observer: shapeList.getSelectList().lastElement()) {
            IShape removedObserver = (IShape) observer;
            removedObserver.clear();
            shapeList.getShapeList().remove(removedObserver);
        }
        // System.out.println(shapeList.getShapeList().size());
        shapeList.getUndoRedoDeleteList().add(shapeList.getSelectList().pop());
        shapeList.getShapeList().forEach(shape -> shape.draw());
    }

    public void deleteShapeUndo() {
        if (shapeList.getUndoRedoDeleteList().isEmpty()) return;
        for (IMovementObserver observer: shapeList.getUndoRedoDeleteList().lastElement()) {
            shapeList.getShapeList().add((IShape) observer);
        }
        shapeList.getSelectList().add(shapeList.getUndoRedoDeleteList().pop());
    }

}
