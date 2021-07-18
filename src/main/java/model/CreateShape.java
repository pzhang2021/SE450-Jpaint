package model;

import model.Command.CommandHistory;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.util.Stack;

public class CreateShape implements ICommand {

    /*
    This class is to create shape through Shape factory, and it implement ICommand so it is able to undo/redo
    the shape. Thus it is shape provider of MouseController also client to ShapeFactory.
     */
    private PaintCanvasBase paintCanvas;
    private Shape shape;
    private ShapeList shapeList;

    public CreateShape(PaintCanvasBase paintCanvas, Shape shape, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.shape = shape;
        this.shapeList = shapeList;
    }

    /*
    Once we start run this class, it will push the new shape into ShapeList
    Same time, we push our command to CommandHistory
     */
    @Override
    public void run() {
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape newShape = shapeFactory.getShape(shape);
        shapeList.addShape(newShape);
        CommandHistory.add(this);
    }

    /*
    Undo method just pop last shape from shapeList and add it to undoRedoList.
    Before we do that, we clear the shape on canvas.
     */
    @Override
    public void undo() {
        Stack<IShape> myShapeList = shapeList.getShapeList();
        Stack<IShape> myUndoRedoShapeList = shapeList.getUndoRedoShapeList();
        if (myShapeList.isEmpty()) {
            return;
        }
        myShapeList.lastElement().clear(paintCanvas.getGraphics2D());
        myUndoRedoShapeList.add(myShapeList.pop());
        // System.out.println("create: undo");
    }

    /*
    Redo is similar as undo, we pop shape from undoRedoList and add it to shapeList, after that redraw this shape on canvas.
     */
    @Override
    public void redo() {
        Stack<IShape> myUndoRedoShapeList = shapeList.getUndoRedoShapeList();
        if (myUndoRedoShapeList.isEmpty()) {
            return;
        }
        shapeList.addShape(myUndoRedoShapeList.pop());
        // System.out.println("create: redo");
    }
}
