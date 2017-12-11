package tasks.task08_28_11_2017.exceptions;

public class InvalidQuantityException extends CandyParseException{
    public InvalidQuantityException() {
    }

    public InvalidQuantityException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "quantity must be positive number!";
    }
}
