package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidAmperageException;
import tasks.task5_17_11_2017.exceptions.InvalidVoltageException;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

public class ElectricalAppliance extends Appliance implements Comparable<ElectricalAppliance> {

    /*Сила тока (амперы)*/
    private int amperage;
    /*Напряжение*/
    private int voltage;
    /*Потребляемая мощность*/
    private int power;
    /*Включен в розетку*/
    private boolean isPluggedIn;

    {
        power = 0;
        isPluggedIn = false;
    }

    public ElectricalAppliance() {

    }

    public ElectricalAppliance(String name, double weight, int amperage, int voltage)
            throws InvalidWeightException, InvalidVoltageException, InvalidAmperageException {

        super(name, weight);
        setAmperage(amperage);
        setVoltage(voltage);
    }

    public int getAmperage() {
        return amperage;
    }

    public void setAmperage(int amperage) throws InvalidAmperageException {
        if (amperage > 0)
            this.amperage = amperage;
        else
            throw new InvalidAmperageException();
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) throws InvalidVoltageException {
        if (voltage > 0)
            this.voltage = voltage;
        else
            throw new InvalidVoltageException();
    }

    public int getPower() {
        return power;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    public void plugIn() {
        this.isPluggedIn = true;
        this.power = this.amperage * this.voltage;
    }

    public void unplug() {
        this.isPluggedIn = false;
        this.power = 0;
    }

    @Override
    public int compareTo(ElectricalAppliance electricalAppliance) {
        return Integer.compare(this.power, electricalAppliance.getPower());
    }

    @Override
    public String toString() {
        return super.toString() +
                "amperage: " + amperage + " A" +
                ", voltage: " + voltage + " V" +
                ", power: " + power + " Vatt" +
                ", isPluggedIn: " + isPluggedIn + ", "
                ;
    }
}
