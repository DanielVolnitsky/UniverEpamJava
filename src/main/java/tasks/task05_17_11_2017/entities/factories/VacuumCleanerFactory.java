package tasks.task05_17_11_2017.entities.factories;

import tasks.task05_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task05_17_11_2017.entities.concreteAppliances.VacuumCleaner;
import tasks.task05_17_11_2017.entities.concreteSwitchingTypes.RunningHamsterType;
import tasks.task05_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class VacuumCleanerFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {

        final int typesCount = VacuumCleaner.Type.values().length;
        int randTypeIndex = getRandomizedInt(0, typesCount);

        return new VacuumCleaner("vacuum cleaner",
                getRandomizedRoundedDouble(5, 10, 1),
                getRandomizedInt(500, 1000),
                new RunningHamsterType(),
                getRandomizedRoundedDouble(0, 2, 1),
                VacuumCleaner.Type.values()[randTypeIndex]);
    }
}
