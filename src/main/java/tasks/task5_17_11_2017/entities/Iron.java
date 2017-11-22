package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidAmperageException;
import tasks.task5_17_11_2017.exceptions.InvalidVoltageException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

public class Iron extends ElectricalAppliance {

    private boolean autoPowerOff;

    {
        setDesignation("to iron");
    }

    public Iron() {

    }

    public Iron(String name, double weight, int amperage, int voltage, boolean autoPowerOff)
            throws InvalidWeightException, InvalidVoltageException, InvalidAmperageException {
        super(name, weight, amperage, voltage);
        this.autoPowerOff = autoPowerOff;
    }

    public boolean isAutoPowerOff() {
        return autoPowerOff;
    }

    public void setAutoPowerOff(boolean autoPowerOff) {
        this.autoPowerOff = autoPowerOff;
    }

    @Override
    public String toString() {
        return "Iron [" + super.toString() +
                "autoPowerOff: " + autoPowerOff + ", " +
                  "]";
    }
}
