package tasks.task06_23_11_2017.stringTask.entities.comparators;

import tasks.task06_23_11_2017.stringTask.entities.Letter;
import tasks.task06_23_11_2017.stringTask.entities.Word;

import java.util.Comparator;

/**
 * КОмпаратор, сравнивающий строки по частоте появления заданой буквы и алфавитному порядку
 */
public class WordComparator implements Comparator<Word> {

    private Letter letter;
    private AlphabeticalStringComparator stringComparator;

    {
        stringComparator = new AlphabeticalStringComparator();
    }

    public WordComparator(Letter letter) {
        this.letter = letter;
    }

    @Override
    /**В случае одинакового кол-ва вхождений буквы в словах, применяется сравнение по алфавиту*/
    public int compare(Word w1, Word w2) {
        int w1Count = getLetterEntranceCount(w1, letter);
        int w2Count = getLetterEntranceCount(w2, letter);

        return w1Count != w2Count ? w1Count - w2Count : stringComparator.compare(w1.getValue(), w2.getValue());
    }

    /**
     * ВОзвращает кол-во вхождений заданной буквы в слове
     *
     * @param coreLetter - искомое слово
     */
    private int getLetterEntranceCount(Word word, Letter coreLetter) {
        int counter = 0;
        for (Letter letter : word.getLetters())
            if (letter.toString().equalsIgnoreCase(coreLetter.toString()))
                counter++;

        return counter;
    }
}
