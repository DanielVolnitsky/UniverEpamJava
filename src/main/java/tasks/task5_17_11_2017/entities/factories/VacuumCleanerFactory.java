package tasks.task5_17_11_2017.entities.factories;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.concreteAppliances.VacuumCleaner;
import tasks.task5_17_11_2017.entities.concreteStrategies.PlugInType;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class VacuumCleanerFactory extends ElectricalApplianceFactory {

    int typesCount = VacuumCleaner.Type.values().length;
    int randTypeIndex = getRandomizedInt(0, typesCount);

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        return new VacuumCleaner("vacuum cleaner",
                getRandomizedRoundedDouble(5, 10, 1),
                getRandomizedInt(500, 1000),
                new PlugInType(),
                getRandomizedRoundedDouble(0, 2, 1),
                VacuumCleaner.Type.values()[randTypeIndex]);
    }
}
