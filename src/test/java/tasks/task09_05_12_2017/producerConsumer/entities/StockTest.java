package tasks.task09_05_12_2017.producerConsumer.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    @Test
    void setProductCount() {
        assertThrows(IllegalArgumentException.class, () ->{
           Stock stock = new Stock(-1);
        });
    }
}