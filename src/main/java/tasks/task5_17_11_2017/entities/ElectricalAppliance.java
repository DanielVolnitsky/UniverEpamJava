package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;
import tasks.task5_17_11_2017.interfaces.SwitchingType;

public class ElectricalAppliance extends Appliance implements Comparable<ElectricalAppliance> {

    /*Тип включения прибора*/
    private SwitchingType switchingType;
    /*Потребляемая мощность*/
    private int power;
    /*Включен в розетку*/
    private Boolean isSwitchedOn;

    {
        power = 0;
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

    public int getPower() {
        if (this.isSwitchedOn)
            return power;
        else
            return 0;
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
    }

    public void switchOff() {
        switchingType.switchOff();
        this.isSwitchedOn = false;
    }

    @Override
    public int compareTo(ElectricalAppliance electricalAppliance) {
        return Integer.compare(this.getPower(), electricalAppliance.getPower());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", power: " + getPower() + " Vatt" +
                ", isSwitchedOn: " + isSwitchedOn +
                ", switchingType: " + switchingType
                ;
    }
}
