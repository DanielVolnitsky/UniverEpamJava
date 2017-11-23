package tasks.task4_16_11_2017.entities;

import org.junit.jupiter.api.*;
import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;

class LocationInfoTest {

    private LocationInfo locationInfo;

    @BeforeEach
     void InitializeLocationInfo() {
        locationInfo = new LocationInfo();
    }

    @AfterEach
     void NullifyLocationInfo() {
        locationInfo = null;
    }

    @Test
    void setLatitude() {
        Assertions.assertThrows(InvalidCoordinatesException.class, () -> {
            locationInfo.setLatitude(-91);
        });
    }

    @Test
    void setLongitude() {
        Assertions.assertThrows(InvalidCoordinatesException.class, () -> {
            locationInfo.setLongitude(181);
        });
    }

}