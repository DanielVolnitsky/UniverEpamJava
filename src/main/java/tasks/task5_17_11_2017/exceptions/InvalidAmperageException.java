package tasks.task5_17_11_2017.exceptions;

public class InvalidAmperageException extends ElectricalApplianceException{
    @Override
    public String getMessage() {
        return "Appliances amperage value can not be less than 0.";
    }
}
