package tasks.task3_07_11_2017.entities.additional;

import tasks.helpers.ArithmeticHelper;
import tasks.task3_07_11_2017.entities.*;
import tasks.task3_07_11_2017.enums.Color;
import tasks.task3_07_11_2017.enums.GeometricalObjectType;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

import java.util.Random;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class GeometricalObjectRandomizer {

    private static Random r = new Random();

    public static GeometricalObject getRandomGeometricalObject() {
        int geomObjCount = GeometricalObjectType.values().length;

        return nextGeometricalObject(r.nextInt(geomObjCount));
    }

    private static GeometricalObject nextGeometricalObject(int ordinal) {

        int colorTypeCount = Color.values().length;
        int minX = -10;
        int maxX = 10;

        int minY = -10;
        int maxY = 10;

        GeometricalObjectType value = GeometricalObjectType.values()[ordinal];
        switch (value) {
            case POINT:
                return nextPoint(minX, maxX, minY, maxY);
            case COLORED_POINT:
                return nextColoredPoint(minX, maxX, minY, maxY, colorTypeCount);
            case LINE:
                return nextLine(minX, maxX, minY, maxY);
            case COLORED_LINE:
                return nextColoredLine(minX, maxX, minY, maxY, colorTypeCount);
            case TRIANGLE:
                return nextTriangle(minX, maxX, minY, maxY);
            case COLORED_TRIANGLE:
                return nextColoredTriangle(minX, maxX, minY, maxY, colorTypeCount);
            case POLYGON:
                return nextPolygon(minX, maxX, minY, maxY);
            case COLORED_POLYGON:
                return nextColoredPolygon(minX, maxX, minY, maxY,  colorTypeCount);
            default:
                return null;
        }
    }

    private static ColoredPolygon nextColoredPolygon(int minX, int maxX, int minY, int maxY, int colorTypeCount) {

        int colorOrdinal = r.nextInt(colorTypeCount);
        Color randColor = Color.values()[colorOrdinal];

        int sidesCount = getRandomizedInt(4, 10);
        Point[] randPoints = new Point[sidesCount];

        for (int i = 0; i < randPoints.length; i++) {
            randPoints[i] = nextPoint(minX, maxX, minY, maxY);
        }

        return new ColoredPolygon(randPoints, randColor);
    }

    private static Polygon nextPolygon(int minX, int maxX, int minY, int maxY) {

        int sidesCount = getRandomizedInt(4, 10);
        Point[] randPoints = new Point[sidesCount];

        for (int i = 0; i < randPoints.length; i++) {
            randPoints[i] = nextPoint(minX, maxX, minY, maxY);
        }

        return new Polygon(randPoints);
    }

    private static Triangle nextTriangle(int minX, int maxX, int minY, int maxY) {
        while (true) {
            Point a = nextPoint(minX, maxX, minY, maxY);
            Point b = nextPoint(minX, maxX, minY, maxY);
            Point c = nextPoint(minX, maxX, minY, maxY);
            try {
                return new Triangle(a, b, c);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static ColoredTriangle nextColoredTriangle(int minX, int maxX, int minY, int maxY, int colorTypeCount) {
        int colorOrdinal = r.nextInt(colorTypeCount);
        Color randColor = Color.values()[colorOrdinal];

        while (true) {
            Point a = nextPoint(minX, maxX, minY, maxY);
            Point b = nextPoint(minX, maxX, minY, maxY);
            Point c = nextPoint(minX, maxX, minY, maxY);
            try {
                return new ColoredTriangle(a, b, c, randColor);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static ColoredLine nextColoredLine(Point p1, Point p2, int colorTypeCount) {
        int colorOrdinal = r.nextInt(colorTypeCount);
        Color randColor = Color.values()[colorOrdinal];

        return new ColoredLine(p1, p2, randColor);
    }

    private static ColoredLine nextColoredLine(int minX, int maxX, int minY, int maxY, int colorTypeCount) {
        while (true) {
            Point p1 = nextPoint(minX, maxX, minY, maxY);
            Point p2 = nextPoint(minX, maxX, minY, maxY);
            try {
                return nextColoredLine(p1, p2, colorTypeCount);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static Line nextLine(Point p1, Point p2) {
        return new Line(p1, p2);
    }

    private static Line nextLine(int minX, int maxX, int minY, int maxY) {
        while (true) {
            Point p1 = nextPoint(minX, maxX, minY, maxY);
            Point p2 = nextPoint(minX, maxX, minY, maxY);
            try {
                return nextLine(p1, p2);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static Point nextPoint(int minX, int maxX, int minY, int maxY) {
        return new Point(getRandomizedInt(minX, maxX), getRandomizedInt(minY, maxY));
    }

    private static ColoredPoint nextColoredPoint(int minX, int maxX, int minY, int maxY, int colorTypeCount) {
        int colorOrdinal = r.nextInt(colorTypeCount);
        Color randColor = Color.values()[colorOrdinal];

        return new ColoredPoint(getRandomizedInt(minX, maxX), getRandomizedInt(minY, maxY), randColor);
    }
}
