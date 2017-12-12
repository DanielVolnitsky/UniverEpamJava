package tasks.task09_05_12_2017.producerConsumer.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckLoaderTest {

    TruckLoader truckLoader;

    @Test
    void setProductCounter() {
        assertThrows(IllegalArgumentException.class, () -> {
           truckLoader = new TruckLoader(new Street(1), new Truck(1), null);
        });
    }

    @Test
    void setStreet() {
        assertThrows(IllegalArgumentException.class, () -> {
            truckLoader = new TruckLoader(null, new Truck(1), null);
        });
    }

    @Test
    void setTruck() {
        assertThrows(IllegalArgumentException.class, () -> {
            truckLoader = new TruckLoader(new Street(1), null, null);
        });
    }
}