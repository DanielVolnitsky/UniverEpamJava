package tasks.task06_23_11_2017.stringTask.entities;

import static java.lang.Character.isLetter;

public class Letter {
    private char value;

    public Letter(char value) throws IllegalArgumentException{
        setValue(value);
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) throws IllegalArgumentException {
        if (isLetter(value))
            this.value = value;
        else
            throw new IllegalArgumentException("given character can't be letter.");
    }

    @Override
    public String toString() {
        return Character.toString(this.getValue());
    }
}
