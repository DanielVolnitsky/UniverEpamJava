package tasks.task5_17_11_2017.entities.concreteAppliances;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;
import tasks.task5_17_11_2017.interfaces.SwitchingType;

/**
 * Класс представляет сущность утюг
 */
public class Iron extends ElectricalAppliance {

    private boolean autoPowerOff;

    {
        setDesignation("to iron");
    }

    public Iron() {

    }

    public Iron(String name, double weight, int power, SwitchingType switchingType, boolean autoPowerOff)
            throws InvalidWeightException, InvalidPowerValueException {
        super(name, weight, power, switchingType);
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
                ", autoPowerOff: " + autoPowerOff +
                  "]";
    }
}
