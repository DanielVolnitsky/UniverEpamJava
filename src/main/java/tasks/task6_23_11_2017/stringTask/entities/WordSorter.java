package tasks.task6_23_11_2017.stringTask.entities;

import tasks.task6_23_11_2017.stringTask.entities.comparators.WordComparator;

import java.util.Arrays;

public class WordSorter {

    final static String EMPTY_STRING = " ";

    private Symbol symbol;
    private String text;

    public WordSorter(String text, Symbol symbol) {
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
