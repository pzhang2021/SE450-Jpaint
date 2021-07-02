package model;

import model.Command.CommandHistory;
import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Stack;

public class CreateShape implements ICommand {
    private PaintCanvasBase paintCanvas;
    private ShapeList shapeList;
    private Coordinate startPoint;
    private Coordinate endPoint;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;

    public CreateShape(PaintCanvasBase paintCanvas, ShapeList shapeList, Coordinate startPoint, Coordinate endPoint, Color primaryColor, Color secondaryColor, ShapeType shapeType, ShapeShadingType shadingType) {
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
    }

    @Override
    public void run() {
        Shape newShape = new Shape(paintCanvas, startPoint, endPoint, primaryColor, secondaryColor, shapeType, shadingType);
        shapeList.addShape(newShape);
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
