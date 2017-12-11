package tasks.task05_17_11_2017.entities.factories;

import tasks.task05_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task05_17_11_2017.entities.concreteAppliances.TableLamp;
import tasks.task05_17_11_2017.entities.concreteSwitchingTypes.PlugInType;
import tasks.task05_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class TableLampFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        int stylesCount = TableLamp.Style.values().length;
        int randStyleIndex = getRandomizedInt(0, stylesCount);

        return new TableLamp("table lamp",
                getRandomizedRoundedDouble(2, 5, 1),
                getRandomizedInt(50, 100),
                new PlugInType(),
                TableLamp.Style.values()[randStyleIndex]);
    }
}
