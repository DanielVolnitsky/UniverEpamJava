package tasks.task6_23_11_2017.stringTask.entities.comparators;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.task6_23_11_2017.stringTask.entities.Symbol;
import tasks.task6_23_11_2017.stringTask.entities.Word;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalStringComparatorTest {

    static String w1, w2, w3;
    static Symbol symbol;
    static AlphabeticalStringComparator asc;

    @BeforeAll
    static void initializeComponents() {
        w1 = "darkness";
        w2 = "darky";
        w3 = "dadarkness";

        symbol = new Symbol('k');
        asc = new AlphabeticalStringComparator();
    }

    @AfterAll
    static void nullifyComponents() {
        w1 = null;
        w2 = null;
        w3 = null;
        symbol = null;
        asc = null;
    }

    @Test
    void compare() {
        int result = asc.compare(w1, w2);
        assertTrue(result < 0);
    }

    @Test
    void compare1() {
        int result = asc.compare(w1, w3);
        assertTrue(result > 0);
    }
}