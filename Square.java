import acm.graphics.GRect;
import java.awt.Color;

public class Square extends GRect {
    private int length;
    private boolean on;
    private Color color;

    public Square(int length, boolean on, Color color){
        super(length, length);
        this.length = length;
        this.on = on;
        this.color = color;
        setFillColor(color);
        setFilled(false);
    }

    public void turnOn(){
        on = true;
        setFilled(true);
    }

    public void turnOff(){
        on = false;
        this.color=color.WHITE;
        setFillColor(Color.WHITE);
        setFilled(false);

    }

    public void setSquareColor(Color color){
        this.color = color;
        setFillColor(color);
    }

    public Color getColor(){
        return color;
    }

    public boolean getOn(){
        return on;
    }

    public void setOn(boolean on){
        if (on){
            turnOn();
        }
        else{
            turnOff();
        }
    }
}
