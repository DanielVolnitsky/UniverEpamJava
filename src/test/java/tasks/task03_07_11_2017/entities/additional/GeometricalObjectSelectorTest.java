package tasks.task03_07_11_2017.entities.additional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.task03_07_11_2017.entities.*;
import tasks.task03_07_11_2017.enums.ColorType;
import tasks.task03_07_11_2017.interfaces.GeometricalObject;

import static org.junit.jupiter.api.Assertions.*;

class GeometricalObjectSelectorTest {
    @Test
    void sortByColorfulUncolorful() {
        ColoredPoint cp1 = new ColoredPoint(3, 6, ColorType.BLACK);
        ColoredPoint cp2 = new ColoredPoint(3, 6, ColorType.BLACK);
        Point p1 = new Point(1, 8);
        ColoredPoint cp3 = new ColoredPoint(3, 6, ColorType.BLACK);

        Point[] points = {cp1, cp2, p1, cp3};
        Point[] expected = {p1, cp2, cp1, cp3};
        GeometricalObjectSelector.sortByColoredUncolored(points);

        Assertions.assertArrayEquals(expected,points);
    }

    @Test
    void getColorfulCount() {
        ColoredPoint cp1 = new ColoredPoint(3, 6, ColorType.BLACK);
        ColoredPoint cp2 = new ColoredPoint(3, 6, ColorType.BLACK);
        Point p1 = new Point(1, 8);
        ColoredPoint cp3 = new ColoredPoint(3, 6, ColorType.BLACK);

        Point[] points = {cp1, cp2, p1, cp3};

        int expected = 3;
        int result = GeometricalObjectSelector.getColoredCount(points);
        assertEquals(expected, result);
    }

    @Test
    void getNotColoredCount() {
        ColoredPoint cp1 = new ColoredPoint(3, 6, ColorType.BLACK);
        ColoredPoint cp2 = new ColoredPoint(3, 6, ColorType.BLACK);
        Point p1 = new Point(1, 8);
        ColoredPoint cp3 = new ColoredPoint(3, 6, ColorType.BLACK);

        Point[] points = {cp1, cp2, p1, cp3};

        int expected = 1;
        int result = GeometricalObjectSelector.getNotColoredCount(points);
        assertEquals(expected, result);
    }

    @Test
    void getPolygonsCount() {
        Point p1 = new Point(1, 8);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(-6, 1);
        Point p4 = new Point(3, 7);

        Point[] pts = new Point[]{p1, p2, p3, p4};
        Polygon pol = new Polygon(pts);
        ColoredPolygon colpol = new ColoredPolygon(pts, ColorType.BLUE);

        GeometricalObject[] gobjs = {p1, p2, pol, colpol, p3, p4};

        int expected = 2;
        int result = GeometricalObjectSelector.getPolygonsCount(gobjs);
        assertEquals(expected, result);
    }

    @Test
    void getTrianglesCount() {
        Point p1 = new Point(1, 8);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(-6, 1);
        Point p4 = new Point(3, 7);

        Triangle tr = new Triangle(p1, p4, p2);
        ColoredTriangle ctr = new ColoredTriangle(p2, p3, p4, ColorType.BLUE);

        GeometricalObject[] gobjs = {p4, tr, ctr, p1, p2};

        int expected = 2;
        int result = GeometricalObjectSelector.getTrianglesCount(gobjs);
        assertEquals(expected, result);
    }

    @Test
    void getLinesCount() {
        Point p1 = new Point(1, 8);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(-6, 1);
        Point p4 = new Point(3, 7);

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p2, p3);
        ColoredLine l3 = new ColoredLine(p4, p1, ColorType.BLUE);

        GeometricalObject[] gobjs = {p4, l1, l2, l3, p1, p2, p3};

        int expected = 3;
        int result = GeometricalObjectSelector.getLinesCount(gobjs);
        assertEquals(expected, result);
    }

    @Test
    void getPointsCount() {
        Point p1 = new Point(1, 8);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(-6, 1);
        Point p4 = new Point(3, 7);

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p2, p3);

        GeometricalObject[] gobjs = {p4, l1, l2, p1, p2, p3};

        int expected = 4;
        int result = GeometricalObjectSelector.getPointsCount(gobjs);
        assertEquals(expected, result);
    }
}