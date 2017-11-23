package tasks.task5_17_11_2017.exceptions;

public class InvalidVacuumCleanerContainerVolumeException extends ElectricalApplianceException{
    @Override
    public String getMessage() {
        return "Vacuum cleaner dust container volume value can not be less than 0.";
    }
}
