package tasks.task6_23_11_2017.regexTask.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class WordFrequencyMapComparatorTest {

    static Map<String, Integer> m1;
    static Map<String, Integer> m2;
    final String SEEK_WORD = "Batman";

    @BeforeAll
    static void setUp() {
        m1 = new HashMap<>();
        m1.put("Batman", 4);

        m2 = new HashMap<>();
        m2.put("Batman", 14);
    }

    @AfterAll
    static void tearDown() {
        m1 = m2 = null;
    }

    @Test
    void compare() {
        WordFrequencyMapComparator comparator = new WordFrequencyMapComparator(SEEK_WORD);
        Assertions.assertTrue(comparator.compare(m1, m2) < 0);
    }
}