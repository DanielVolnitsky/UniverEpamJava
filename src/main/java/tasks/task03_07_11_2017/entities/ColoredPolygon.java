package tasks.task03_07_11_2017.entities;

import tasks.task03_07_11_2017.enums.ColorType;
import tasks.task03_07_11_2017.interfaces.Colored;

public class ColoredPolygon extends Polygon implements Colored {
    private ColorType color;

    public ColoredPolygon(Point[] points, ColorType color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toString() {
        return "coloredPolygon {" + "color: " + color + ", " + super.toString() + "} ";
    }
}
