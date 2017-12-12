package tasks.task03_07_11_2017.entities.additional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task03_07_11_2017.entities.Line;
import tasks.task03_07_11_2017.entities.Point;
import tasks.task03_07_11_2017.entities.Triangle;
import tasks.task03_07_11_2017.interfaces.GeometricalObject;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializationHelperTest {

    Point p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Point(1, 2);
        p2 = new Point(4, 5);
        p3 = new Point(3, 8);
    }

    @Test
    void deserialize() {
        GeometricalObject[] expected = {p1, p2, p3};
        GeometricalObject[] result = new GeometricalObject[expected.length];

        File file = new File("src\\main\\java\\tasks\\task03_07_11_2017\\additional\\SerializedGeomObjects");

        SerializationHelper.serialize(file, expected);
        SerializationHelper.deserialize(file, result);

        assertTrue(Arrays.equals(expected, result));
    }
}