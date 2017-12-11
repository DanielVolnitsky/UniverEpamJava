package tasks.task08_28_11_2017.comparators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.task08_28_11_2017.entities.Candy;
import tasks.task08_28_11_2017.entities.Manufacturer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CandyComparatorTest {

    static Manufacturer manufacturer;
    static Candy c1, c2, c3;

    @BeforeAll
    static void setUp() {
        manufacturer = new Manufacturer();
        c1 = new Candy("ads", "c1", (byte) 1, Candy.CandyType.CARAMEL, true, manufacturer);
        c2 = new Candy("ads", "c1", (byte) 1, Candy.CandyType.CARAMEL, true, manufacturer);
        c3 = new Candy("ads", "c1", (byte) 1, Candy.CandyType.CARAMEL, true, new Manufacturer("arg", "arf"));
    }

    @Test
    void compare() {
        boolean result = c1.equals(c2);
        assertTrue(result);
    }

    @Test
    void compare1() {
        boolean result = c1.equals(c3);
        assertFalse(result);
    }
}