package tasks.task03_07_11_2017.entities;

import tasks.task03_07_11_2017.enums.ColorType;
import tasks.task03_07_11_2017.interfaces.Colored;

public class ColoredTriangle extends Triangle implements Colored {

    private ColorType color;

    public ColoredTriangle(Point apexA, Point apexB, Point apexC, ColorType color) {
        super(apexA, apexB, apexC);
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
        return "coloredTriangle {" +
                "color: " + color +
                "} " + super.toString();
    }
}
