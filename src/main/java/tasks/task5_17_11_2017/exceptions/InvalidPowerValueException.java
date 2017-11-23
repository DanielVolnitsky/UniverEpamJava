package tasks.task5_17_11_2017.exceptions;

public class InvalidPowerValueException extends ElectricalApplianceException{
    @Override
    public String getMessage() {
        return "Appliances power value can not be less than 0.";
    }
}
