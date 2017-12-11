package tasks.task05_17_11_2017.entities.concreteSwitchingTypes;

import tasks.task05_17_11_2017.interfaces.SwitchingType;

/**
 * Конкретная стратегия типа включения электроприбора - используя включение в розетку
 *
 * @see SwitchingType
 */
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
