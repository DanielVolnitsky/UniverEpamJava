package tasks.task09_05_12_2017.beesAndPuch.entities;

import org.junit.jupiter.api.Test;
import tasks.exceptions.InvalidIdException;

import static org.junit.jupiter.api.Assertions.*;

class BeeFlockTest {

    BeeFlock beeFlock;

    @Test
    void setFlockID() {
        assertThrows(InvalidIdException.class, () ->{
            beeFlock = new BeeFlock(-1);
        });
    }
}