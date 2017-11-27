package tasks;

import tasks.task7_24_11_2017.entities.Calculator;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Calculator.calculate("cos(1) + sin(2 - 1)"));
        } catch (IllegalArgumentException | EmptyStackException ex) {
            System.err.println(ex.getMessage());
        }
    }
}