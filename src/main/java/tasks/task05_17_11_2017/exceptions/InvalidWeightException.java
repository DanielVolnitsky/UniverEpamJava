package tasks.task05_17_11_2017.exceptions;

public class InvalidWeightException extends ElectricalApplianceException {
    @Override
    public String getMessage() {
        return "Weight can not be less than 0.";
    }
}
