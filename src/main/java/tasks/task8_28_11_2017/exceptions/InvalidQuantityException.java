package tasks.task8_28_11_2017.exceptions;

public class InvalidQuantityException extends Exception{

    public InvalidQuantityException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "quantity must be positive number!";
    }
}
