package tasks.task6_23_11_2017.stringTask.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordSorterTest {

    private static String text;
    private static Symbol symbol;
    private static WordSorter wordSorter;

    @BeforeAll
    static void initializeComponents() {
        text = "hahaha aha ha h";
        symbol = new Symbol('a');
        wordSorter = new WordSorter(text, symbol);
    }

    @AfterAll
    static void nullifyComponents() {
        text = null;
        symbol = null;
    }

    @Test
    void getSortedBySymbolFrequency() {
        Word[] result = wordSorter.getSortedBySymbolFrequency();
        Word[] expected = {new Word("h"), new Word("ha"), new Word("aha"), new Word("hahaha")};

        assertTrue(Arrays.equals(result, expected));
    }
}