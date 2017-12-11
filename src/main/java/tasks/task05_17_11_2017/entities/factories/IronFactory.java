package tasks.task05_17_11_2017.entities.factories;

import tasks.task05_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task05_17_11_2017.entities.concreteAppliances.Iron;
import tasks.task05_17_11_2017.entities.concreteSwitchingTypes.BatteryUsingType;
import tasks.task05_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class IronFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        return new Iron("iron",
                getRandomizedRoundedDouble(2, 5, 1),
                getRandomizedInt(500, 2000),
                new BatteryUsingType(),
                false);
    }
}
