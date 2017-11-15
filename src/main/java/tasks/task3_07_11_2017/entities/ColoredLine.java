package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.Color;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class ColoredLine extends Line{
    private Color color;

   protected ColoredLine() {

    }

    public ColoredLine(Point beg, Point end, Color color) {
        super(beg, end);
        this.color = color;
    }

    public ColoredLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2);
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
        return "coloredLine { color: " + color + ", " + super.toString() + "} ";
    }
}
