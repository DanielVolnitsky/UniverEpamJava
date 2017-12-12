package tasks.task09_05_12_2017.buddistCompetition.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkTest {
    Monk monk;
    @Test
    void setChiEnergy() {
        assertThrows(IllegalArgumentException.class, () -> {
            monk = new Monk(-1);
        });
    }

}