package tasks.task5_17_11_2017.exceptions;

public class InvalidVoltageException extends ElectricalApplianceException{
    @Override
    public String getMessage() {
        return "Appliances voltage value can not be less than 0.";
    }
}
