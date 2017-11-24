package tasks.task5_17_11_2017.entities.basicAppliances;

import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;
import tasks.task5_17_11_2017.interfaces.SwitchingType;

/**
 * Класс представляет сущность электроприбора
 *
 * @see Appliance
 */
public class ElectricalAppliance extends Appliance implements Comparable<ElectricalAppliance> {

    /*Тип включения прибора*/
    private SwitchingType switchingType;
    /*Потребляемая мощность*/
    private int power;
    /*текущая потребляемая мощность*/
    private int currentPower;

    private Boolean isSwitchedOn;

    {
        currentPower = 0;
        isSwitchedOn = false;
    }

    public ElectricalAppliance() {

    }

    public ElectricalAppliance(String name, double weight, int power, SwitchingType switchingType)
            throws InvalidWeightException, InvalidPowerValueException {

        super(name, weight);
        setPower(power);
        this.switchingType = switchingType;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws InvalidPowerValueException {
        if (power > 0)
            this.power = power;
        else
            throw new InvalidPowerValueException();
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public void switchOn() {
        switchingType.switchOn();
        this.isSwitchedOn = true;
        this.currentPower = power;
    }

    public void switchOff() {
        switchingType.switchOff();
        this.isSwitchedOn = false;
        this.currentPower = 0;
    }

    @Override
    public int compareTo(ElectricalAppliance electricalAppliance) {
        return Integer.compare(this.getPower(), electricalAppliance.getPower());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", power: " + getPower() + " Vatt" +
                ", currentPower: " + getCurrentPower() + " Vatt" +
                ", isSwitchedOn: " + isSwitchedOn +
                ", switchingType: " + switchingType
                ;
    }
}
