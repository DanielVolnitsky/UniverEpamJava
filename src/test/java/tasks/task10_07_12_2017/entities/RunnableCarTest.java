package tasks.task10_07_12_2017.entities;

import org.junit.jupiter.api.*;
import tasks.exceptions.InvalidIdException;
import tasks.exceptions.InvalidTimeValueException;

import static org.junit.jupiter.api.Assertions.*;

class RunnableCarTest {

    static RunnableCar car;

    @BeforeAll
    static void setUp() throws InvalidIdException, InvalidTimeValueException {
        car = new RunnableCar(1,1,1);
    }

    @AfterAll
    static void tearDown() {
        car = null;
    }

    @Test
    void setMaxWaitTime() {
        assertThrows(InvalidTimeValueException.class, () ->{
            car.setMaxWaitTime(-1);
        });
    }

    @Test
    void setTimeAtParking() {
        assertThrows(InvalidTimeValueException.class, () ->{
            car.setTimeAtParking(-1);
        });
    }

    @Test
    void setCarID() {
        assertThrows(InvalidIdException.class, () ->{
            car.setCarID(-1);
        });
    }
}