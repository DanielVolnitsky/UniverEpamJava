package tasks.task6_23_11_2017.stringTask.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordSorterTest {

    private static String text;
    private static Letter letter;
    private static WordsHelper wordsHelper;

    @BeforeAll
    static void initializeComponents() {
        text = "hahaha aha ha h";
        letter = new Letter('a');
       // wordsHelper = new WordsHelper(text, letter);
    }

    @AfterAll
    static void nullifyComponents() {
        text = null;
        letter = null;
    }

//    @Test
//    void sortWordsByLetterFrequency() {
//        Word[] result = wordsHelper.sortWordsByLetterFrequency();
//        Word[] expected = {new Word("h"), new Word("ha"), new Word("aha"), new Word("hahaha")};
//
//        assertTrue(Arrays.equals(result, expected));
//    }
}