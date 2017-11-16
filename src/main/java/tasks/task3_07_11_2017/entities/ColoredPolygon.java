package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.enums.Color;
import tasks.task3_07_11_2017.interfaces.Colorful;

public class ColoredPolygon extends Polygon implements Colorful {
    private Color color;

    public ColoredPolygon(int facetCount, int radius, Point center, Color color) {
        super(facetCount, radius, center);
        this.color = color;
    }

    @Override
    public String toString() {
        return "coloredPolygon: " +
                "color: " + color +
                ", " + super.toString();
    }
}
