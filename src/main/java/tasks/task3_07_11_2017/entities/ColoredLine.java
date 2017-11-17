package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.ColorType;
import tasks.task3_07_11_2017.interfaces.Colored;

public class ColoredLine extends Line implements Colored {
    private ColorType color;

   protected ColoredLine() {

    }

    public ColoredLine(Point beg, Point end, ColorType color) {
        super(beg, end);
        this.color = color;
    }

    public ColoredLine(int x1, int y1, int x2, int y2, ColorType color) {
        super(x1, y1, x2, y2);
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
        return "coloredLine { color: " + color + ", " + super.toString() + "} ";
    }
}
