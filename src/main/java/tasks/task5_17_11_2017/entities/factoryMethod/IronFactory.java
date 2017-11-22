package tasks.task5_17_11_2017.entities.factoryMethod;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.Iron;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class IronFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        return new Iron("rand. iron", getRandomizedRoundedDouble(2, 5, 1), getRandomizedInt(3, 10),
                getRandomizedInt(100, 220), false);
    }
}
