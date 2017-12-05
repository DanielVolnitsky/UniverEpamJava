package tasks.task8_28_11_2017.exceptions;

public class InvalidCaloricityException extends Exception {

    @Override
    public String getMessage() {
        return "Caloricity must be positive int number!";
    }
}
