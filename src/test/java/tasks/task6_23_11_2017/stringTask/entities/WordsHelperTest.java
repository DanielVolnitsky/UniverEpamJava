package tasks.task6_23_11_2017.stringTask.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.helpers.FileHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class WordsHelperTest {

    final static String filePath = "src\\main\\java\\tasks\\task6_23_11_2017\\stringTask\\beesAndPuch\\TestExample";

    static List<Letter> l1, l2, l3;
    static Word w1, w2, w3;
    static List<Word> words;
    static List<Word> words2;

    @BeforeAll
    static void initializeComponents() {
        l1 = new ArrayList<>();
        l1.add(new Letter('w'));
        l1.add(new Letter('a'));
        l1.add(new Letter('y'));


        List<Letter> l2 = new ArrayList<>();
        l2.add(new Letter('t'));
        l2.add(new Letter('o'));

        List<Letter> l3 = new ArrayList<>();
        l3.add(new Letter('e'));
        l3.add(new Letter('p'));
        l3.add(new Letter('a'));
        l3.add(new Letter('m'));

        w1 = new Word(l1);
        w2 = new Word(l2);
        w3 = new Word(l3);

        words = new ArrayList<>();
        words.add(w1);
        words.add(w2);
        words.add(w3);
    }

    @Test
    void fillWordsByByteArray() {
        try {
            byte[] fileBytes = FileHelper.getFileBytes(filePath);
            words2 = new ArrayList<>();
            WordsHelper.fillWordsByByteArray(fileBytes, words2);

            assertEquals(words, words2);
        } catch (IOException e) {
            fail("Invald file path");
        }
    }

    @Test
    void sortWordsByLetterFrequency() {
        fillWordsByByteArray();
        Letter coreLetter = new Letter('a');
        List<Word> expected = new ArrayList<>();
        expected.add(w2);
        expected.add(w3);
        expected.add(w1);
        List<Word> result = new ArrayList<>(expected);
        WordsHelper.sortWordsByLetterFrequency(result, coreLetter);

        assertEquals(expected, result);
    }
}