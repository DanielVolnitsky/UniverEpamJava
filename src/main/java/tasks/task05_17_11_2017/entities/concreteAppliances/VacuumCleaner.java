package tasks.task05_17_11_2017.entities.concreteAppliances;

import tasks.task05_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task05_17_11_2017.exceptions.InvalidVacuumCleanerContainerVolumeException;
import tasks.task05_17_11_2017.exceptions.InvalidPowerValueException;
import tasks.task05_17_11_2017.exceptions.InvalidWeightException;
import tasks.task05_17_11_2017.interfaces.SwitchingType;

/**
 * Класс представляет сущность пылесос
 */
public class VacuumCleaner extends ElectricalAppliance {

    /*Объем пылесборника (л)*/
    private double containerVolume;

    /*Тип пылесоса*/
    private Type type;

    {
        setDesignation("to vacuum");
    }

    public VacuumCleaner() {

    }

    public VacuumCleaner(String name, double weight, int power, SwitchingType switchingType, double containerVolume, Type type)
            throws InvalidWeightException, InvalidPowerValueException, InvalidVacuumCleanerContainerVolumeException {
        super(name, weight, power, switchingType);
        setContainerVolume(containerVolume);
        this.type = type;
    }

    public double getContainerVolume() {
        return containerVolume;
    }

    public void setContainerVolume(double containerVolume) throws InvalidVacuumCleanerContainerVolumeException {
        if (containerVolume > 0)
            this.containerVolume = containerVolume;
        else
            throw new InvalidVacuumCleanerContainerVolumeException();
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
                ", containerVolume: " + containerVolume + "l " +
                ", type: " + type +
                "]";
    }

    public static enum Type {
        DRY_CLEANING, WINDOW
    }
}
