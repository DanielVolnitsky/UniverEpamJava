package tasks.task09_05_12_2017.beesAndPuch.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ForestTest {
    Forest forest;

    @Test
    void setLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            forest = new Forest(-1, 1);
        });
    }

    @Test
    void setWidth() {
        assertThrows(IllegalArgumentException.class, () -> {
            forest = new Forest(1, -1);
        });
    }

}