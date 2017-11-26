package tasks.task6_23_11_2017.stringTask.entities.comparators;

import tasks.task6_23_11_2017.stringTask.entities.Symbol;
import tasks.task6_23_11_2017.stringTask.entities.Word;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

    private Symbol symbol;
    private AlphabeticalStringComparator stringComparator;

    {
        stringComparator = new AlphabeticalStringComparator();
    }

    public WordComparator(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(Word w1, Word w2) {
        int w1Count = getSymbolEntranceCount(w1, symbol);
        int w2Count = getSymbolEntranceCount(w2, symbol);

        return w1Count != w2Count ? w1Count - w2Count : stringComparator.compare(w1.getValue(), w2.getValue());
    }

    private int getSymbolEntranceCount(Word word, Symbol symbol) {
        String value = word.getValue();
        return value.length() - value.replace(symbol.toString(), "").length();
    }
}
