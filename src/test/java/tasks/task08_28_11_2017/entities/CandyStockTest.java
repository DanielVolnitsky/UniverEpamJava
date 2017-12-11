package tasks.task08_28_11_2017.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandyStockTest {

    static CandyStock candyStock;
    static List<Candy> nullList;
    static Candy nullCandy;

    @BeforeAll
    static void setUp() {
        nullCandy = null;
        candyStock = new CandyStock();
        nullList = new ArrayList<>();
        nullList.add(nullCandy);
    }

    @Test
    void addCandyList() {
        candyStock.addCandyList(nullList);
        int expected = 0;
        int result = candyStock.getCandies().size();
        assertEquals(expected, result);
    }

    @Test
    void addCandy() {
        candyStock.addCandy(nullCandy);
        int expected = 0;
        int result = candyStock.getCandies().size();
        assertEquals(expected, result);
    }
}