package tasks.task09_05_12_2017.beesAndPuch.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeehiveTest {

   Beehive beehive;

    @Test
    void setBeeFlockCount() {
        assertThrows(IllegalArgumentException.class, () ->{
            beehive = new Beehive(-1, new Forest(1,1));
        });
    }

    @Test
    void setForest() {
        assertThrows(IllegalArgumentException.class, () ->{
            beehive = new Beehive(1, null);

        });
    }
}