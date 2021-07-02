package model;

import java.awt.*;

public enum ShapeColor {
    BLACK {
        public Color getColor(){
            return Color.BLACK;
        }
    },
    BLUE {
        public Color getColor(){
            return Color.BLUE;
        }
    },
    CYAN {
        public Color getColor(){
            return Color.CYAN;
        }
    },
    DARK_GRAY {
        public Color getColor(){
            return Color.darkGray;
        }
    },
    GRAY {
        public Color getColor(){
            return Color.GRAY;
        }
    },
    GREEN {
        public Color getColor(){
            return Color.GREEN;
        }
    },
    LIGHT_GRAY {
        public Color getColor(){
            return Color.lightGray;
        }
    },
    MAGENTA {
        public Color getColor(){
            return Color.MAGENTA;
        }
    },
    ORANGE {
        public Color getColor(){
            return Color.orange;
        }
    },
    PINK {
        public Color getColor(){
            return Color.pink;
        }
    },
    RED {
        public Color getColor(){
            return Color.red;
        }
    },
    WHITE {
        public Color getColor(){
            return Color.white;
        }
    },
    YELLOW {
        public Color getColor(){
            return Color.yellow;
        }
    };

    Color color;

    public Color getColor() {
        return this.color;
    }
}
