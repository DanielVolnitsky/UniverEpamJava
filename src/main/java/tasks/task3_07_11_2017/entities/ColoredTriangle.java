package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.Color;

public class ColoredTriangle extends Triangle {

    private Color color;

    public ColoredTriangle(Point apexA, Point apexB, Point apexC, Color color) {
        super(apexA, apexB, apexC);
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
        return "coloredTriangle {" +
                "color: " + color +
                "} " + super.toString();
    }
}
