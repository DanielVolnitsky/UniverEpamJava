package tasks.helpers;

import org.junit.jupiter.api.Test;
import tasks.task3_07_11_2017.entities.Point;
import tasks.task3_07_11_2017.entities.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class GeometricHelperTest {
    @Test
    void getTrianglePerimeter() {
        System.out.println("\nTriangle perimeter");

        Point a = new Point(1,2);
        Point b = new Point(4,8);
        Point c = new Point(5, -6);

        Triangle tr = new Triangle(a,b,c);

        double expected = 29.688;
        double result = GeometricHelper.getTrianglePerimeter(tr);
        int compRes = Double.compare(expected, result);

        assertEquals(compRes, 0);
    }

    @Test
    void getTriangleArea() {
        System.out.println("Triangle area");

        Point a = new Point(1,2);
        Point b = new Point(4,8);
        Point c = new Point(5, -6);

        Triangle tr = new Triangle(a,b,c);

        double expected = 24.0;
        double result = GeometricHelper.getTriangleArea(tr);
        int compRes = Double.compare(expected, result);

        assertEquals(compRes, 0);
    }

    @Test
    void isPointsOnSameLine() {
        Point a = new Point(2,1);
        Point b = new Point(4,2);
        Point c = new Point(6, 3);

        boolean expected = true;
        boolean result = GeometricHelper.isPointsOnSameLine(a,b,c);

        assertEquals(expected, result);
    }

    @Test
    void equalPoints() {
        Point a = new Point(2,1);
        Point b = new Point(2,1);

        boolean expected = true;
        boolean result = GeometricHelper.equalPoints(a,b);

        assertEquals(expected, result);
    }

    @Test
    void equalPoints1() {
        Point a = new Point(2,1);
        Point b = new Point(2,1);
        Point c = new Point(2,1);

        boolean expected = true;
        boolean result = GeometricHelper.equalPoints(a,b,c);

        assertEquals(expected, result);
    }

    @Test
    void rotate() {
        Point a = new Point(3,4);
        Point b = new Point(4,2);
        Point c = new Point(6,3);

        int expected = 5;
        int result = GeometricHelper.rotate(a,b,c);

        assertEquals(expected, result);
    }
}