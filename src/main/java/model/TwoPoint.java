package model;

/**
 * This class is to store two start point and end point coordinate and calculate their left corner coordinate width and height
 */
public class TwoPoint {
    private Coordinate startPoint;
    private Coordinate endPoint;
    private int leftCornerX;
    private int leftCornerY;
    private int width;
    private int height;

    public TwoPoint(Coordinate startPoint, Coordinate endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Coordinate getStartPoint() {
        return startPoint;
    }

    public Coordinate getEndPoint() {
        return endPoint;
    }

    public int getLeftCornerX() {
        leftCornerX = Math.min(startPoint.getX(), endPoint.getX());
        return leftCornerX;
    }

    public int getLeftCornerY() {
        leftCornerY = Math.min(startPoint.getY(), endPoint.getY());
        return leftCornerY;
    }

    public int getWidth() {
        width = Math.abs(startPoint.getX() - endPoint.getX());
        return width;
    }

    public int getHeight() {
        height = Math.abs(startPoint.getY() - endPoint.getY());
        return height;
    }

    public TwoPoint switchPoint() {
        return new TwoPoint(endPoint, startPoint);
    }
}
