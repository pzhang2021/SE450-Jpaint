package model.interfaces;

import java.awt.*;

public interface IShape {
    /*
    This is abstract method to provide function of shape to other classes
     */
    void draw(Graphics2D g);
    void clear(Graphics2D g);
}
