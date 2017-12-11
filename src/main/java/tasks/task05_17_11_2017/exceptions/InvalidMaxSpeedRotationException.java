package tasks.task05_17_11_2017.exceptions;

public class InvalidMaxSpeedRotationException extends ElectricalApplianceException{
    @Override
    public String getMessage() {
        return "Drills max. speed of rotation value can not be less than 0.";
    }
}
