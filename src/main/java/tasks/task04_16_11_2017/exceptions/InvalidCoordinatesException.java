package tasks.task04_16_11_2017.exceptions;

public class InvalidCoordinatesException extends Exception {

    private String additionalText;

    public InvalidCoordinatesException(String additionalText){
        this.additionalText = additionalText;
    }
    @Override
    public String getMessage() {
        return "Invalid coordinates passed. " + additionalText;
    }
}
