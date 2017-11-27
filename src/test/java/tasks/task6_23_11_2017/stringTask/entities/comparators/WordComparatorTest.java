package tasks.task6_23_11_2017.stringTask.entities.comparators;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.task6_23_11_2017.stringTask.entities.Letter;
import tasks.task6_23_11_2017.stringTask.entities.Word;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordComparatorTest {

    static Word w1, w2, w3;
    static Letter letter;
    static WordComparator wc;

    @BeforeAll
    static void initializeComponents() {
//        w1 = new Word("darkness");
//        w2 = new Word("darky");
//        w3 = new Word("dadarkness");

        letter = new Letter('k');
        wc = new WordComparator(letter);
    }

    @AfterAll
    static void nullifyComponents() {
        w1 = null;
        w2 = null;
        w3 = null;
        letter = null;
        wc = null;
    }

    @Test
    void compare() {
        int result = wc.compare(w1, w2);
        assertTrue(result < 0);
    }

    @Test
    void compare1() {
        int result = wc.compare(w1, w3);
        assertTrue(result > 0);
    }
}