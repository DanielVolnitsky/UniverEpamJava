package tasks.task3_07_11_2017.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {
    @Test
    void canMakeTriangle() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(5, -6);

        boolean expected = false;
        boolean result = Triangle.canMakeTriangle(a, b, c);
        assertEquals(expected, result);

        b.setX(5);
        b.setY(8);
        expected = true;
        result = Triangle.canMakeTriangle(a, b, c);
        assertEquals(expected, result);
    }
}