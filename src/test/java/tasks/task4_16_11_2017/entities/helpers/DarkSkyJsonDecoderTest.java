package tasks.task4_16_11_2017.entities.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DarkSkyJsonDecoderTest {
    @Test
    void getCurrentForecast() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            DarkSkyJsonDecoder d = new DarkSkyJsonDecoder(null);
            d.getCurrentForecast();
        });
    }

}