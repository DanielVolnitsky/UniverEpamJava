package tasks.task09_05_12_2017.producerConsumer.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StockStealerTest {

    StockStealer stockStealer;

    @BeforeEach
    void setUp() {

    }

    @Test
    void setStock() {
        assertThrows(IllegalArgumentException.class, () -> {
            stockStealer = new StockStealer(null, new Street(5), null);
        });
    }

    @Test
    void setStreet() {
        assertThrows(IllegalArgumentException.class, () -> {
            stockStealer = new StockStealer(new Stock(1), null, null);
        });
    }

    @Test
    void setTruckLoader() {
        assertThrows(IllegalArgumentException.class, () -> {
            stockStealer = new StockStealer(new Stock(1), new Street(1), null);
        });
    }
}