package tasks.task6_23_11_2017.regexTask.entities;

import org.junit.jupiter.api.Test;
import tasks.helpers.FileHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WordsFrequencyDemonstratorTest {

    @Test
    void initializeUrlList() {
        try {
            String filePath = "src\\main\\java\\tasks\\task6_23_11_2017\\regexTask\\beesAndPuch\\SiteBodyExample";
            String mockBodyText = new String(FileHelper.getFileBytes(filePath));

            SiteInfoHelper mockito = mock(SiteInfoHelper.class);
            String mockString = mockBodyText;
            when(mockito.getSiteBodyText()).thenReturn(mockString);

            String bodyText = mockito.getSiteBodyText();
            List<String> urls = Arrays.asList(SiteInfoHelper.getPageBodyUrls(bodyText));

            WordsFrequencyDemonstrator demonstrator = new WordsFrequencyDemonstrator(urls, "someWord");

            List<String> expectedUrls = new ArrayList<>();
            expectedUrls.add("w3schools.com");
            expectedUrls.add("https://www.w3schools.com/");
            List<String> result = demonstrator.getUrls();

            assertEquals(expectedUrls, result);

        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}