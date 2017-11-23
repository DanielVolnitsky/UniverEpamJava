package tasks.task5_17_11_2017.entities.concreteSwitchingTypes;

import tasks.task5_17_11_2017.interfaces.SwitchingType;

/**
 * Конкретная стратегия типа включения электроприбора - используя бегущего хомяка
 *
 * @see SwitchingType
 */
public class RunningHamsterType implements SwitchingType {

    @Override
    public void switchOn() {
        System.out.println("hamster started running.");
    }

    @Override
    public void switchOff() {
        System.out.println("hamster stopped.");
    }

    @Override
    public String toString() {
        return "running hamster.";
    }
}
