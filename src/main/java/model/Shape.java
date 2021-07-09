package model;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Shape {

    private Coordinate startPoint;
    private Coordinate endPoint;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;

    // maybe need it later
    private int width;
    private int height;

    public Shape(Coordinate startPoint, Coordinate endPoint, Color primaryColor, Color secondaryColor, ShapeType shapeType, ShapeShadingType shadingType) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
    }

    public void draw(Graphics2D g) {
        // points details, we want start at left corner
        int startPointX = Math.min(startPoint.getX(), endPoint.getX());
        int startPointY = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());

        g.setColor(primaryColor);
        // rectangle
        if (shapeType == ShapeType.RECTANGLE) {
            g.fillRect(startPointX, startPointY, width, height);
        }
        // triangle
        // ellipse
    }
}
