package tasks.task5_17_11_2017.entities.factories;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.concreteAppliances.Iron;
import tasks.task5_17_11_2017.entities.concreteStrategies.BatteryUsingType;
import tasks.task5_17_11_2017.entities.concreteStrategies.PlugInType;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

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
