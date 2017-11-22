package tasks.task5_17_11_2017.entities.factoryMethod;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.TableLamp;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;
import static tasks.helpers.ArithmeticHelper.getRandomizedRoundedDouble;

public class TableLampFactory extends ElectricalApplianceFactory {

    @Override
    public ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException {
        int stylesCount = TableLamp.Style.values().length;
        int randStyleIndex = getRandomizedInt(0, stylesCount);

        return new TableLamp("rand. table lamp", getRandomizedRoundedDouble(2, 5, 1), getRandomizedInt(3, 10),
                getRandomizedInt(10, 20), TableLamp.Style.values()[randStyleIndex]);
    }
}
