package tasks.task09_05_12_2017.producerConsumer.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {
    @Test
    void setMaxProductPresented() {
        assertThrows(IllegalArgumentException.class, () ->{
            Street street = new Street(-1);
        });
    }
}