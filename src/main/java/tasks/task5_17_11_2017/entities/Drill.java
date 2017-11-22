package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidAmperageException;
import tasks.task5_17_11_2017.exceptions.InvalidMaxSpeedRotationException;
import tasks.task5_17_11_2017.exceptions.InvalidVoltageException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

public class Drill extends ElectricalAppliance {

    /*об/мин*/
    private double maxSpeedOfRotation;

    {
        setDesignation("to drill");
    }

    public Drill() {

    }

    public Drill(String name, double weight, int amperage, int voltage, double maxSpeedOfRotation)
            throws InvalidWeightException, InvalidVoltageException, InvalidAmperageException, InvalidMaxSpeedRotationException {

        super(name, weight, amperage, voltage);
        setMaxSpeedOfRotation(maxSpeedOfRotation);
    }

    public double getMaxSpeedOfRotation() {
        return maxSpeedOfRotation;
    }

    public void setMaxSpeedOfRotation(double maxSpeedOfRotation) throws InvalidMaxSpeedRotationException {
        if(maxSpeedOfRotation > 0)
            this.maxSpeedOfRotation = maxSpeedOfRotation;
        else
            throw new InvalidMaxSpeedRotationException();
    }

    @Override
    public String toString() {
        return "Drill [" + super.toString() +
                "maxSpeedOfRotation: " + maxSpeedOfRotation +
                "]";
    }
}
