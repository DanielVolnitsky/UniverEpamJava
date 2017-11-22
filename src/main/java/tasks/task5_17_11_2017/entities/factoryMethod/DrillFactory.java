package tasks.task5_17_11_2017.entities.factoryMethod;

import tasks.task5_17_11_2017.entities.Drill;
import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;
import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class DrillFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        return new Drill("rand. drill", getRandomizedRoundedDouble(0, 2, 1), getRandomizedInt(1, 5),
                getRandomizedInt(100, 220), getRandomizedInt(1000, 4000));
    }
}
