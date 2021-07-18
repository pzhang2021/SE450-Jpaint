package model;

import model.interfaces.IShape;

import java.awt.*;

public class Triangle implements IShape {

    Shape shape;

    public Triangle(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void clear(Graphics2D g) {

    }
}
