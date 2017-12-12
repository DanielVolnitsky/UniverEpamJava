package tasks.task09_05_12_2017.producerConsumer.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    void setMaxUnaccountedPossible() {
        assertThrows(IllegalArgumentException.class, () ->{
            Truck truck = new Truck(-1);
        });
    }
}