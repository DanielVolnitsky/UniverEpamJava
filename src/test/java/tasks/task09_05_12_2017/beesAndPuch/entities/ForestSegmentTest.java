package tasks.task09_05_12_2017.beesAndPuch.entities;

import org.junit.jupiter.api.Test;
import tasks.exceptions.InvalidIdException;

import static org.junit.jupiter.api.Assertions.*;

class ForestSegmentTest {
    ForestSegment forestSegment;
    @Test
    void setSegmentIndex() {
        assertThrows(IllegalArgumentException.class, () ->{
            forestSegment = new ForestSegment(-1);
        });
    }
}