package tasks.task03_07_11_2017.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolygonTest {
    @Test
    void setPoints() {
        Point [] pts = {new Point(1,2), new Point(4,7), new Point(3,-8)};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Polygon p = new Polygon(pts);
        });
    }
}