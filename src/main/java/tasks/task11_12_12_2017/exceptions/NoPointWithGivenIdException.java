package tasks.task11_12_12_2017.exceptions;

public class NoPointWithGivenIdException extends Exception {
    @Override
    public String getMessage() {
        return "no point with given parameteres founded in DB";
    }
}
