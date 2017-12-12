package tasks.task09_05_12_2017.producerConsumer.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCounterTest {
    @Test
    void setTruck() {
        assertThrows(IllegalArgumentException.class, () ->{
            ProductCounter pc = new ProductCounter(null);
        });
    }
}