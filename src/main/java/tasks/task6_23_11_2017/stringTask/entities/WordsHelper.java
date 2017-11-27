package tasks.task6_23_11_2017.stringTask.entities;

import tasks.task6_23_11_2017.stringTask.entities.comparators.WordComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Character.isLetter;

public class WordsHelper {

    /**
     * Заполняет список слов по данным из массива байтов
     */
    public static void fillWordsByByteArray(byte[] bytes, List<Word> words) {
        int i, j;
        for (i = 0; i < bytes.length; i++) {
            char currChar = (char) bytes[i];
            if (isLetter(currChar)) {
                List<Letter> letters = new ArrayList<>();
                for (j = i; isLetter((char) bytes[j]) && j < bytes.length; j++) {
                    letters.add(new Letter((char) bytes[j]));
                }
                i = j;
                words.add(new Word(letters));
            }
        }
    }

    /**
     * Сортирует список слов по частоте появления в них заданной буквы
     * или в алфаавитном порядке в случаи одинакового вхождения
     */
    public static void sortWordsByLetterFrequency(List<Word> words, Letter letter) {
        WordComparator wordComparator = new WordComparator(letter);
        Collections.sort(words, wordComparator);
    }
}
