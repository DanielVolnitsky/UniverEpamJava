package tasks.task4_16_11_2017.entities.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.task4_16_11_2017.interfaces.UrlMaker;

import static org.junit.jupiter.api.Assertions.*;

class DarkSkyUrlMakerTest {
    @Test
    void getUrl() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            UrlMaker urlMaker = new DarkSkyUrlMaker(null);
            urlMaker.getUrl();
        });
    }
}