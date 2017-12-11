package tasks.exceptions;

public class InvalidIdException extends Exception {
    @Override
    public String getMessage() {
        return "ID must be positive integer value!";
    }
}
