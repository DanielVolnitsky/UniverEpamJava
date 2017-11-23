package tasks.task5_17_11_2017.entities.concreteSwitchingTypes;

import tasks.task5_17_11_2017.interfaces.SwitchingType;

/**
 * Конкретная стратегия типа включения электроприбора - используя батарею
 *
 * @see SwitchingType
 */
public class BatteryUsingType implements SwitchingType {

    @Override
    public void switchOn() {
        System.out.println("battery on");
    }

    @Override
    public void switchOff() {
        System.out.println("battery off");
    }

    @Override
    public String toString() {
        return "battery using";
    }
}
