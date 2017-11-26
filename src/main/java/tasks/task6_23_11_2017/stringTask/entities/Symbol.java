package tasks.task6_23_11_2017.stringTask.entities;

public class Symbol {
    private char value;

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Character.toString(this.getValue());
    }
}
