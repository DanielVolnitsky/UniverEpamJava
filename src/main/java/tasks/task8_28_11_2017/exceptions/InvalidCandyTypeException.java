package tasks.task8_28_11_2017.exceptions;

public class InvalidCandyTypeException extends Exception {

    @Override
    public String getMessage() {
        return "There is no such candy type in registered type of candies";
    }
}
