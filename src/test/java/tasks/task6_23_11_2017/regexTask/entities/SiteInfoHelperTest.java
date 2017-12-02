package tasks.task6_23_11_2017.regexTask.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SiteInfoHelperTest {

    private final String WORKING_URL = "https://www.w3schools.com/";

    @BeforeAll
    static void initializing(){

    }

    @Test
    void getSiteBodyText() {
        Assertions.assertThrows(IOException.class, () -> {
            SiteInfoHelper.getSiteBodyText("not real url");
        });
    }

    @Test
    void getSiteBodyText1() {
        try {
            SiteInfoHelper.getSiteBodyText(WORKING_URL);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void getSiteBodyText2() {
        Assertions.assertThrows(IOException.class, () -> {
            SiteInfoHelper.getSiteBodyText(null);
        });
    }

    @Test
    void getPageBodyUrls() {
        String text = "https://translate.google.ru/\n" +
                "The side bar includes a Cheatsheet, full Reference, and Help. " +
                "You can also Save & Share your expressions with the Community, " +
                "and mark Favourites.\n" +
                "https://regexr.com/";

        String [] expected = {"https://translate.google.ru/","https://regexr.com/"};
        String [] result = SiteInfoHelper.getPageBodyUrls(text);

        Assertions.assertTrue(Arrays.equals(expected,result));
    }
}