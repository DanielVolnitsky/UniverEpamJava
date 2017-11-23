package tasks.task5_17_11_2017.entities.concreteStrategies;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.interfaces.SwitchingType;

public class PlugInType implements SwitchingType {

    @Override
    public void switchOn() {
        System.out.println("plugged in.");
    }

    @Override
    public void switchOff() {
        System.out.println("plugged off.");
    }

    @Override
    public String toString() {
        return "plugging in";
    }
}
