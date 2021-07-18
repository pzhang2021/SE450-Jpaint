package model;

import model.interfaces.IShape;

import java.awt.*;

public class Rectangle implements IShape {

    Shape shape;
    private int startPointX;
    private int startPointY;
    // maybe need it later
    private int width;
    private int height;

    public Rectangle(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics2D g) {
        startPointX = Math.min(shape.getStartPoint().getX(), shape.getEndPoint().getX());
        startPointY = Math.min(shape.getStartPoint().getY(), shape.getEndPoint().getY());
        width = Math.abs(shape.getStartPoint().getX() - shape.getEndPoint().getX());
        height = Math.abs(shape.getStartPoint().getY() - shape.getEndPoint().getY());
        g.setColor(shape.getPrimaryColor());
        g.fillRect(startPointX, startPointY, width, height);
    }

    @Override
    public void clear(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(startPointX, startPointY, width, height);
    }
}
