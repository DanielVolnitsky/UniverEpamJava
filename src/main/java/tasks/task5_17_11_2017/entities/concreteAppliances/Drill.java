package tasks.task5_17_11_2017.entities.concreteAppliances;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.InvalidMaxSpeedRotationException;
import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;
import tasks.task5_17_11_2017.interfaces.SwitchingType;

/**
 * Класс представляет сущность дрель
 */
public class Drill extends ElectricalAppliance {

    /*об/мин*/
    private double maxRotationSpeed;

    {
        setDesignation("to drill");
    }

    public Drill() {

    }

    public Drill(String name, double weight, int power, SwitchingType switchingType, double maxRotationSpeed)
            throws InvalidWeightException, InvalidPowerValueException, InvalidMaxSpeedRotationException {

        super(name, weight, power, switchingType);
        setMaxRotationSpeed(maxRotationSpeed);
    }

    public double getMaxRotationSpeed() {
        return maxRotationSpeed;
    }

    public void setMaxRotationSpeed(double maxRotationSpeed) throws InvalidMaxSpeedRotationException {
        if (maxRotationSpeed > 0)
            this.maxRotationSpeed = maxRotationSpeed;
        else
            throw new InvalidMaxSpeedRotationException();
    }

    @Override
    public String toString() {
        return "Drill [" + super.toString() +
                ", maxRotationSpeed: " + maxRotationSpeed + " rot/min" +
                "]";
    }
}
