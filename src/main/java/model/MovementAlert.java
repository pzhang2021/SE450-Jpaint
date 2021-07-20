package model;

import model.interfaces.IMovementObserver;

import java.util.Stack;

/**
 * This is Observer Pattern
 * It used by SelectCommand to addObserver and used by MoveCommand to update new coordinate to all observers
 */
public class MovementAlert {

    private Stack<IMovementObserver> observers;

    public void addObserver(ShapeList shapeList, TwoPoint twoPoint) {
        CollisionDetection collisionDetection = new CollisionDetection(shapeList, twoPoint);
        collisionDetection.addSelectShape();
    }

    public void addMovement(TwoPoint twoPoint, ShapeList shapeList) {
        shapeList.getMovementList().add(twoPoint);
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(twoPoint, shapeList);
    }

    public void undoMove(ShapeList shapeList) {
        TwoPoint twoPoint = shapeList.getMovementList().lastElement().switchPoint();
        shapeList.getUndoRedoMovementList().add(shapeList.getMovementList().pop());
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(twoPoint, shapeList);
    }

    public void redoMove(ShapeList shapeList) {
        TwoPoint twoPoint = shapeList.getUndoRedoMovementList().lastElement().switchPoint();
        shapeList.getMovementList().add(shapeList.getUndoRedoMovementList().pop());
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(twoPoint, shapeList);
    }

    private void notifyAllObservers(TwoPoint twoPoint, ShapeList shapeList) {
        observers.forEach(observer -> observer.clear());
        observers.forEach(observer -> observer.update(twoPoint));
        shapeList.getShapeList().forEach(shape -> shape.draw());
    }
}
