package tasks.task07_24_11_2017.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    static String ex1, ex2, ex3;

    @BeforeAll
    static void initializeExamples() {
        ex1 = "-1 + sin(2 + 2.2) - cos(1)";
        ex2 = "1 + 8 *";
        ex3 = "2 1 + 8";
    }

    @Test
    void calculate() {
        double expected = -2.411878078281728;
        double result = Calculator.calculate(ex1);

        assertEquals(expected, result);
    }

    @Test
    void calculate1() {
        Assertions.assertThrows(EmptyStackException.class, () -> {
            Calculator.calculate(ex2);
        });
    }

    @Test
    void isTokenUnaryPlusOrMinusOperation() {
        boolean expected = true;
        boolean result = Calculator.isTokenUnaryPlusOrMinusOperation('+', '(');

        assertEquals(expected, result);
    }
}