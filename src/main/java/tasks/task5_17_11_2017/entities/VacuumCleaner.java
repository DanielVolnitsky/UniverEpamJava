package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidAmperageException;
import tasks.task5_17_11_2017.exceptions.InvalidDustContainerVolumeException;
import tasks.task5_17_11_2017.exceptions.InvalidVoltageException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

public class VacuumCleaner extends ElectricalAppliance {

    /*Объем пылесборника (л)*/
    private double dustContainerVolume;

    /*Тип пылесоса*/
    private Type type;

    {
        setDesignation("to vacuum");
    }

    public VacuumCleaner() {

    }

    public VacuumCleaner(String name, double weight, int amperage, int voltage, double dustContainerVolume, Type type)
            throws InvalidWeightException, InvalidVoltageException, InvalidAmperageException, InvalidDustContainerVolumeException {
        super(name, weight, amperage, voltage);
        setDustContainerVolume(dustContainerVolume);
        this.type = type;
    }

    public double getDustContainerVolume() {
        return dustContainerVolume;
    }

    public void setDustContainerVolume(double dustContainerVolume) throws InvalidDustContainerVolumeException {
        if (dustContainerVolume > 0)
            this.dustContainerVolume = dustContainerVolume;
        else
            throw new InvalidDustContainerVolumeException();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VacuumCleaner [" + super.toString() +
                "dustContainerVolume: " + dustContainerVolume + "l " +
                ", type: " + type +
                "]" ;
    }

    public static enum Type {
        DRY_CLEANING, WINDOW
    }
}
