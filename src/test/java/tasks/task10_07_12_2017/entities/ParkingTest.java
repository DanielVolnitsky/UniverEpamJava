package tasks.task10_07_12_2017.entities;

import org.junit.jupiter.api.Test;
import tasks.exceptions.InvalidTimeValueException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingTest {
    @Test
    void setParkingSlots() {
        assertThrows(IllegalArgumentException.class, () ->{
            Parking parking = new Parking(1, "abc");
            parking.setParkingSlots(-1);
        });
    }
}
