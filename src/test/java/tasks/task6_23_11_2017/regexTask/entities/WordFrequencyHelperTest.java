package tasks.task6_23_11_2017.regexTask.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class WordFrequencyHelperTest {

    static Map<String, Map<String, Integer>> outerMap;
    static Map<String, Map<String, Integer>> expected;
    static Map<String, Map<String, Integer>> result;
    static Map<String, Integer> expected1;
    static Map<String, Integer> result1;
    static Map<String, Integer> m1, m2, m3;
    final String SEEK_WORD = "Batman";

    @BeforeAll
    static void setUp() {
        m1 = new HashMap<>();
        m2 = new HashMap<>();
        m3 = new HashMap<>();

        m1.put("Superman", 3);
        m1.put("Batman", 4);
        m1.put("WonderWoman", 2);
        m2.put("Superman", 5);
        m2.put("Batman", 14);
        m2.put("WonderWoman", 22);
        m3.put("Superman", 3);
        m3.put("Batman", 7);
        m3.put("WonderWoman", 5);

        outerMap = new HashMap<>();
        outerMap.put("firstUrl", m1);
        outerMap.put("secondUrl", m2);
        outerMap.put("thirdUrl", m3);

        expected = new HashMap<>();
    }

    @AfterAll
    static void tearDown() {
        m1 = m2 = m3 = null;
        outerMap = null;
        expected1 = result1 = null;
    }

    /*How to test?*/
    @Test
    void getMapSortedByWordFrequency() {
        expected = new LinkedHashMap<>();

        expected.put("firstUrl", m1);
        expected.put("thirdUrl", m3);
        expected.put("secondUrl", m2);

        result = WordFrequencyHelper.getMapSortedByWordFrequency(outerMap, SEEK_WORD);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void fillWordsFrequencyMap() {
        String text = "She ...! ,always -wanted";

        expected1 = new LinkedHashMap<>();
        expected1.put("She", 1);
        expected1.put("always", 1);
        expected1.put("wanted", 1);

        result1 = new LinkedHashMap<>();
        WordFrequencyHelper.fillWordsFrequencyMap(result1, text);
        Assertions.assertEquals(expected1, result1);
    }
}