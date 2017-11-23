package tasks.task5_17_11_2017.entities.concreteAppliances;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;
import tasks.task5_17_11_2017.interfaces.SwitchingType;

public class TableLamp extends ElectricalAppliance {

    private Style style;

    {
        setDesignation("to lamp");
    }

    public TableLamp() {

    }

    public TableLamp(String name, double weight, int power, SwitchingType switchingType, Style style)
            throws InvalidWeightException, InvalidPowerValueException {
        super(name, weight, power, switchingType);
        this.style = style;
    }

    @Override
    public String toString() {
        return "TableLamp [" + super.toString() +
                ", style: " + style +
                "]";
    }

    public enum Style {
        CLASSICAL, MODERN
    }
}
