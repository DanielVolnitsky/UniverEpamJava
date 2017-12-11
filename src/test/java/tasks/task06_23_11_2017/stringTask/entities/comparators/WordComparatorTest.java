package tasks.task06_23_11_2017.stringTask.entities.comparators;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.task06_23_11_2017.stringTask.entities.Letter;
import tasks.task06_23_11_2017.stringTask.entities.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordComparatorTest {

    static Word w1, w2, w3;
    static Letter letter;
    static WordComparator wc;

    @BeforeAll
    static void initializeComponents() {
        letter = new Letter('d');

        List<Letter> l1 = new ArrayList<>();
        l1.add(letter);
        l1.add(new Letter('o'));
        l1.add(letter);

        List<Letter> l2 = new ArrayList<>();
        l2.add(letter);
        l2.add(letter);
        l2.add(letter);

        List<Letter> l3 = new ArrayList<>();
        l3.add(new Letter('c'));
        l3.add(new Letter('a'));
        l3.add(letter);

        w1 = new Word(l1);
        w2 = new Word(l2);
        w3 = new Word(l3);

        wc = new WordComparator(letter);
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

    @AfterAll
    static void nullifyComponents() {
        w1 = null;
        w2 = null;
        w3 = null;
        letter = null;
        wc = null;
    }
}