package tasks.task04_16_11_2017.entities;

import org.junit.jupiter.api.*;
import tasks.task04_16_11_2017.exceptions.InvalidCoordinatesException;

class LocationTest {

    private Location location;

    @BeforeEach
     void InitializeLocationInfo() {
        location = new Location();
    }

    @AfterEach
     void NullifyLocationInfo() {
        location = null;
    }

    @Test
    void setLatitude() {
        Assertions.assertThrows(InvalidCoordinatesException.class, () -> {
            location.setLatitude(-91);
        });
    }

    @Test
    void setLongitude() {
        Assertions.assertThrows(InvalidCoordinatesException.class, () -> {
            location.setLongitude(181);
        });
    }

}