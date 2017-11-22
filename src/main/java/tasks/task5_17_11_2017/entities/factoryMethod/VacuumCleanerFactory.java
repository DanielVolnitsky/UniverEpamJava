package tasks.task5_17_11_2017.entities.factoryMethod;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.VacuumCleaner;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class VacuumCleanerFactory extends ElectricalApplianceFactory {

    int typesCount = VacuumCleaner.Type.values().length;
    int randTypeIndex = getRandomizedInt(0, typesCount);

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        return new VacuumCleaner("rand. vacuum cleaner", getRandomizedRoundedDouble(10, 20, 1), getRandomizedInt(16, 30),
                getRandomizedInt(100, 220), getRandomizedRoundedDouble(0, 2, 1), VacuumCleaner.Type.values()[randTypeIndex]);
    }
}
