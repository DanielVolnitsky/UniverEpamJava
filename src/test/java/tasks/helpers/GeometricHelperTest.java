package tasks.helpers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task03_07_11_2017.entities.Point;
import tasks.task03_07_11_2017.entities.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeometricHelperTest {

    Point a,b,c;
    Triangle triangle;

    @BeforeEach
    public void initPoints(){
        a = new Point(1, 2);
        b = new Point(4, 8);
        c = new Point(5, -6);
    }

    @AfterEach
    public void nullifyPoints(){
        a = null;
        b = null;
        c = null;
    }

    @Test
    void getTrianglePerimeter() {

        triangle = new Triangle(a, b, c);

        double expected = 29.688;
        double result = GeometricHelper.getTrianglePerimeter(triangle);
        int compRes = Double.compare(expected, result);

        assertEquals(compRes, 0);
    }

    @Test
    void getTriangleArea() {

        triangle = new Triangle(a, b, c);

        double expected = 24.0;
        double result = GeometricHelper.getTriangleArea(triangle);
        int compRes = Double.compare(expected, result);

        assertEquals(compRes, 0);
    }

    @Test
    void isPointsOnSameLine() {

        boolean expected = false;
        boolean result = GeometricHelper.isPointsOnSameLine(a, b, c);
        assertEquals(expected, result);

        Point d = new Point(2, 1);
        Point e = new Point(4, 2);
        Point f = new Point(6, 3);

        expected = true;
        result = GeometricHelper.isPointsOnSameLine(d, e, f);
        assertEquals(expected, result);
    }

    @Test
    void equalPoints() {

        boolean expected = false;
        boolean result = GeometricHelper.equalPoints(a, b);
        assertEquals(expected, result);

        Point d = new Point(2, 1);
        Point e = new Point(2, 1);

        expected = true;
        result = GeometricHelper.equalPoints(d, e);
        assertEquals(expected, result);
    }

    @Test
    void equalPoints1() {
        Point d = new Point(2, 1);
        Point e = new Point(2, 1);
        Point f = new Point(2, 1);

        boolean expected = true;
        boolean result = GeometricHelper.equalPoints(d, e, f);
        assertEquals(expected, result);
    }

    @Test
    void rotate() {
        Point d = new Point(3, 4);
        Point e = new Point(4, 2);
        Point f = new Point(6, 3);

        int expected = 5;
        int result = GeometricHelper.rotate(d, e, f);
        assertEquals(expected, result);
    }
}