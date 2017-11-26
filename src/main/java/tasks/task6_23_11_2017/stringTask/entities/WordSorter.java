package tasks.task6_23_11_2017.stringTask.entities;

import tasks.task6_23_11_2017.stringTask.entities.comparators.WordComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordSorter {

    final static String EMPTY_STRING = " ";

    private Symbol symbol;
    private String text;

    private List<String> words;

    public WordSorter(Symbol symbol, String text) {
        if (symbol != null && text.length() > 0) {
            this.symbol = symbol;
            this.text = text;
        }
    }

    public Word[] getSortedBySymbolFrequency() {
        String[] strings = text.split("[\\W]");
        Word[] words = new Word[strings.length];

        for (int i = 0; i < words.length; i++)
            words[i] = new Word(strings[i]);

        WordComparator comp = new WordComparator(symbol);
        Arrays.sort(words, comp);

        return words;
    }
}
