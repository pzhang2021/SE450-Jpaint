package model;

import model.Command.CommandHistory;
import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Stack;

public class CreateShape implements ICommand {

    private Shape shape;
    private ShapeList shapeList;

    public CreateShape(Shape shape, ShapeList shapeList) {
        this.shape = shape;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        shapeList.addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        Stack<Shape> myShapeList = shapeList.getShapeList();
        Stack<Shape> myUndoRedoShapeList = shapeList.getUndoRedoShapeList();
        if (myShapeList.isEmpty()) {
            return;
        }
        myUndoRedoShapeList.add(myShapeList.pop());
        shapeList.redraw();
        // System.out.println("create: undo");
    }

    @Override
    public void redo() {
        Stack<Shape> myUndoRedoShapeList = shapeList.getUndoRedoShapeList();
        if (myUndoRedoShapeList.isEmpty()) {
            return;
        }
        shapeList.addShape(myUndoRedoShapeList.pop());
        // System.out.println("create: redo");
    }
}
