package model;

public class Coordinate {

    /*
    This is class for storing coordinate, other class are able to derive it through getter
    and use it for creating shape
     */

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
