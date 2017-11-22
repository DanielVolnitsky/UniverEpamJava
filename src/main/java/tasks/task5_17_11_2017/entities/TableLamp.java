package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidAmperageException;
import tasks.task5_17_11_2017.exceptions.InvalidVoltageException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

public class TableLamp extends ElectricalAppliance {

    private Style style;

    {
        setDesignation("to lamp");
    }

    public TableLamp() {

    }

    public TableLamp(String name, double weight, int amperage, int voltage, Style style)
            throws InvalidWeightException, InvalidVoltageException, InvalidAmperageException {
        super(name, weight, amperage, voltage);
        this.style = style;
    }

    @Override
    public String toString() {
        return "TableLamp [" + super.toString() +
                "style: " + style +
                "]";
    }

    public enum Style {
        CLASSICAL, MODERN
    }
}
