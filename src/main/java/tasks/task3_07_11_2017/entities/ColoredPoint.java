package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.Color;
import tasks.task3_07_11_2017.interfaces.Colorful;

public class ColoredPoint extends Point implements Colorful {
    private Color color;

    protected ColoredPoint() {
        super();
    }

    public ColoredPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "coloredPoint [" + super.toString() + ", color: " + color + "]";
    }
}
