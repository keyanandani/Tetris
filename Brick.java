import java.awt.*;
import java.util.ArrayList;

public class Brick {
    private Color color;

    public ArrayList<Position> getSquares(){
        ArrayList<Position> squares = new ArrayList<Position>();
        if (shape == Shape.L){
            if (rotation == 0){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x+1,y+1));
            }
            if (rotation == 1){
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x-1,y+1));
            }
            if (rotation == 2){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x-1,y-1));
            }
            if (rotation == 3){
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x+1,y-1));
            }
        }
        if (shape == Shape.I){
            if (rotation == 0){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x,y+2));
            }
            if (rotation ==2){
                squares.add(new Position(x-1,y-1));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x-1,y+1));
                squares.add(new Position(x-1,y+2));
            }
            if (rotation==1){
                squares.add(new Position(x,y+1));
                squares.add(new Position(x+1,y+1));
                squares.add(new Position(x-1,y+1));
                squares.add(new Position(x-2,y+1));
            }
            if (rotation==3){
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x-2,y));
            }

        }
        if (shape == Shape.J){
            if (rotation == 0){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x-1,y+1));
            }
            if (rotation == 1){
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x-1,y-1));
            }
            if (rotation == 2){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x+1,y-1));
            }
            if (rotation == 3){
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x+1,y+1));
            }


        }
        if (shape == Shape.S){
            if (rotation == 0 ){
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x-1,y+1));
                squares.add(new Position(x+1,y));
            }
            if (rotation == 2){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x+1,y-1));
            }
            if(rotation == 1){
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x-1,y-1));
                squares.add(new Position(x,y+1));
            }
            if(rotation == 3){
                squares.add(new Position(x+1,y));
                squares.add(new Position(x,y));
                squares.add(new Position(x,y-1));
                squares.add(new Position(x+1,y+1));
            }


        }
        if (shape == Shape.Z){
            if (rotation == 0 ){
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x+1,y+1));
            }
            if (rotation==2){
                squares.add(new Position(x,y-1));
                squares.add(new Position(x-1,y-1));
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y));
            }
            if (rotation==1){
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x,y-1));
                squares.add(new Position(x-1,y+1));
            }
            if (rotation==3){
                squares.add(new Position(x+1,y));
                squares.add(new Position(x,y));
                squares.add(new Position(x+1,y-1));
                squares.add(new Position(x,y+1));
            }


        }
        if (shape == Shape.O){
            squares.add(new Position(x,y));
            squares.add(new Position(x,y+1));
            squares.add(new Position(x+1,y));
            squares.add(new Position(x+1,y+1));
        }
        if (shape == Shape.T){
            if (rotation == 0){
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x,y+1));
            }
            if (rotation == 1){
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x,y-1));
            }
            if (rotation == 2){
                squares.add(new Position(x,y));
                squares.add(new Position(x-1,y));
                squares.add(new Position(x+1,y));
                squares.add(new Position(x,y-1));
            }
            if (rotation == 3){
                squares.add(new Position(x,y));
                squares.add(new Position(x,y+1));
                squares.add(new Position(x,y-1));
                squares.add(new Position(x+1,y));
            }

        }

        return squares;
    }

    public void rotate(){
        rotation = (rotation+1)%4;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Shape shape;
    private int rotation;
    private int x;
    private int y;

    public Brick(Color color, Shape shape, int rotation, int x, int y){
        this.color = color;
        this.shape = shape;
        this.rotation = rotation;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

enum Shape{
    I, O, T, S, Z, J, L;
}


