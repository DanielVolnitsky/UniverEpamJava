package tasks.task5_17_11_2017.entities.factories;

import tasks.task5_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.concreteAppliances.Drill;
import tasks.task5_17_11_2017.entities.concreteSwitchingTypes.BatteryUsingType;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class DrillFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        return new Drill("drill",
                getRandomizedRoundedDouble(0, 2, 1),
                getRandomizedInt(300, 600),
                new BatteryUsingType(),
                getRandomizedRoundedDouble(0, 2, 1));
    }
}
