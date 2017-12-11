package tasks.exceptions;

public class InvalidTimeValueException extends Exception {

    @Override
    public String getMessage() {
        return "Time must be positive integer value!";
    }
}
