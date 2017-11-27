package tasks.task6_23_11_2017.stringTask.entities;

import java.util.List;

public class Word {

    private String value;
    private List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = letters;
        setValue();
    }

    private void setValue() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters)
            result.append(letter.getValue());

        this.value = result.toString();
    }

    public String getValue() {
        return value;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return value != null ? value.equals(word.value) : word.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
