package tasks.task03_07_11_2017.entities.additional;

import tasks.task03_07_11_2017.entities.*;
import tasks.task03_07_11_2017.enums.ColorType;
import tasks.task03_07_11_2017.interfaces.GeometricalObject;

import java.util.Random;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;


/**
 * Класс генерирует и возвращает случайный объект типа GeometricalObject
 *
 * @see tasks.helpers.ArithmeticHelper
 * @see GeometricalObject
 */
public class GeometricalObjectRandomizer {

    private final static int MIN_X = -10;
    private final static int MAX_X = 10;

    private final static int MIN_Y = -10;
    private final static int MAX_Y = 10;

    private static Random r = new Random();

    public static GeometricalObject getRandomGeometricalObject() {
        int count = GeometricalObjectType.values().length;
        return nextGeometricalObject(r.nextInt(count));
    }

    public static GeometricalObject getRandomColoredGeometricalObject() {
        int count = ColoredGeometricalObjectType.values().length;
        return nextColoredGeometricalObject(r.nextInt(count));
    }

    /**
     * @param ordinal - порядковый номер объекта типа ColoredGeometricalObjectType
     */
    private static GeometricalObject nextColoredGeometricalObject(int ordinal) {

        int colorTypeCount = ColorType.values().length;

        ColoredGeometricalObjectType value = ColoredGeometricalObjectType.values()[ordinal];
        switch (value) {
            case COLORED_POINT:
                return nextColoredPoint(colorTypeCount);
            case COLORED_LINE:
                return nextColoredTriangle(colorTypeCount);
            case COLORED_TRIANGLE:
                return nextColoredPolygon(colorTypeCount);
            case COLORED_POLYGON:
                return nextColoredPolygon(colorTypeCount);
            default:
                return null;
        }
    }

    /**
     * @param ordinal - порядковый номер объекта типа GeometricalObjectType
     */
    private static GeometricalObject nextGeometricalObject(int ordinal) {

        GeometricalObjectType value = GeometricalObjectType.values()[ordinal];
        switch (value) {
            case POINT:
                return nextPoint();
            case LINE:
                return nextLine();
            case TRIANGLE:
                return nextTriangle();
            case POLYGON:
                return nextPolygon();
            default:
                return null;
        }
    }

    private static Point nextPoint() {
        return new Point(getRandomizedInt(MIN_X, MAX_X), getRandomizedInt(MIN_Y, MAX_Y));
    }

    private static ColoredPoint nextColoredPoint(int colorTypeCount) {
        return new ColoredPoint(getRandomizedInt(MIN_X, MAX_X), getRandomizedInt(MIN_Y, MAX_Y), getRandomColor(colorTypeCount));
    }

    private static ColoredPolygon nextColoredPolygon(int colorTypeCount) {
        int sidesCount = getRandomizedInt(4, 10);
        Point[] randPoints = new Point[sidesCount];

        for (int i = 0; i < randPoints.length; i++)
            randPoints[i] = nextPoint();

        return new ColoredPolygon(randPoints, getRandomColor(colorTypeCount));
    }

    private static Polygon nextPolygon() {
        int sidesCount = getRandomizedInt(4, 10);
        Point[] randPoints = new Point[sidesCount];

        for (int i = 0; i < randPoints.length; i++)
            randPoints[i] = nextPoint();

        return new Polygon(randPoints);
    }

    private static Triangle nextTriangle() {
        while (true) {
            Point a = nextPoint();
            Point b = nextPoint();
            Point c = nextPoint();
            try {
                return new Triangle(a, b, c);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static ColoredTriangle nextColoredTriangle(int colorTypeCount) {
        while (true) {
            Point a = nextPoint();
            Point b = nextPoint();
            Point c = nextPoint();
            try {
                return new ColoredTriangle(a, b, c, getRandomColor(colorTypeCount));
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static ColoredLine nextColoredLine(Point p1, Point p2, int colorTypeCount) {
        return new ColoredLine(p1, p2, getRandomColor(colorTypeCount));
    }

    private static ColoredLine nextColoredLine(int colorTypeCount) {
        while (true) {
            Point p1 = nextPoint();
            Point p2 = nextPoint();
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

    private static Line nextLine() {
        while (true) {
            Point p1 = nextPoint();
            Point p2 = nextPoint();
            try {
                return nextLine(p1, p2);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static ColorType getRandomColor(int colorTypeCount) {
        int colorOrdinal = r.nextInt(colorTypeCount);
        return ColorType.values()[colorOrdinal];
    }

    private static enum GeometricalObjectType {
        POINT, LINE, TRIANGLE, POLYGON,
    }

    private static enum ColoredGeometricalObjectType {
        COLORED_POINT, COLORED_LINE, COLORED_TRIANGLE, COLORED_POLYGON
    }
}
