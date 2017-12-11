package tasks.task04_16_11_2017.entities.helpers;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

class JsonHelperTest {
    @Test
    void getJsonObject() {

        Assertions.assertThrows(MalformedURLException.class, () -> {
            JsonHelper jsonHelper = new JsonHelper("invalid url");
            JSONObject obj = jsonHelper.getJsonObject();
        });
    }

}