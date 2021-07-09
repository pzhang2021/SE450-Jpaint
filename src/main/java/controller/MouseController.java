package controller;

import model.*;
import model.Shape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    private final ApplicationState appState;
    private final PaintCanvasBase paintCanvas;
    private final ShapeList shapeList;
    private Coordinate startPoint;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;


    public MouseController(ApplicationState appState, PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Coordinate(e.getX(), e.getY());
        // System.out.println("start point at " + startPoint.getX() + ", " + startPoint.getY());
        /*
        when we start to press mouse, when are able to determine all characteristics of the shape
        so we want to store the values for drawing/moving/selecting/copying
         */
        shapeType = appState.getActiveShapeType();
        shadingType = appState.getActiveShapeShadingType();
        // color
        ShapeColor getPrimaryColor = appState.getActivePrimaryColor();
        primaryColor = getPrimaryColor.getColor();
        ShapeColor getSecondaryColor = appState.getActiveSecondaryColor();
        secondaryColor = getSecondaryColor.getColor();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Coordinate endPoint = new Coordinate(e.getX(), e.getY());
        // System.out.println("end point at " + endPoint.getX() + ", " + endPoint.getY());
        if(appState.getActiveMouseMode() == MouseMode.DRAW) {
            CreateShape createShape = new CreateShape(new Shape(startPoint, endPoint, primaryColor, secondaryColor, shapeType, shadingType), shapeList);
            createShape.run();
        }
    }
}
