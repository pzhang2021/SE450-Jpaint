package model;

import model.interfaces.IMovementObserver;
import model.interfaces.IShape;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 *     This is MVC class, it is data model for storing undo, redo shape(s).
 *     This class initiate at the beginning of the program so other classes are able to access it.
 */
public class ShapeList{
    private Stack<IShape> shapeList = new Stack<>();
    private Stack<IShape> undoRedoShapeList = new Stack<>();
    private Stack<Stack<IMovementObserver>> selectList = new Stack<>();
    private Stack<Stack<IMovementObserver>> undoRedoSelectList = new Stack<>();
    private Stack<TwoPoint> movementList = new Stack<>();
    private Stack<TwoPoint> undoRedoMovementList = new Stack<>();
    private Stack<IMovementObserver> clipboard = new Stack<>();
    private Stack<Integer> pasteList = new Stack<>();
    private Stack<Stack<IMovementObserver>> undoRedoPasteItem = new Stack<>();
    private Stack<Stack<IMovementObserver>> undoRedoDeleteList = new Stack<>();

    public void addShape(IShape iShape) {
        shapeList.add(iShape);
        iShape.draw();
    }

    public Stack<IShape> getShapeList() {
        return shapeList;
    }

    public Stack<IShape> getUndoRedoShapeList() {
        return undoRedoShapeList;
    }

    public Stack<Stack<IMovementObserver>> getSelectList() {
        return selectList;
    }

    public Stack<Stack<IMovementObserver>> getUndoRedoSelectList() {
        return undoRedoSelectList;
    }

    public Stack<TwoPoint> getMovementList() {
        return movementList;
    }

    public Stack<TwoPoint> getUndoRedoMovementList() {
        return undoRedoMovementList;
    }

    public Stack<IMovementObserver> getClipboard() {
        return clipboard;
    }

    public Stack<Integer> getPasteList() {
        return pasteList;
    }

    public Stack<Stack<IMovementObserver>> getUndoRedoPasteItem() {
        return undoRedoPasteItem;
    }

    public Stack<Stack<IMovementObserver>> getUndoRedoDeleteList() {
        return undoRedoDeleteList;
    }
}
