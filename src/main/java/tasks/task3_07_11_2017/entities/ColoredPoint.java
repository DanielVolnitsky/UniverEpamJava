package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.ColorType;
import tasks.task3_07_11_2017.interfaces.Colored;

public class ColoredPoint extends Point implements Colored {
    private ColorType color;

    protected ColoredPoint() {
        super();
    }

    public ColoredPoint(int x, int y, ColorType color) {
        super(x, y);
        this.color = color;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "coloredPoint [" + super.toString() + ", color: " + color + "]";
    }
}
