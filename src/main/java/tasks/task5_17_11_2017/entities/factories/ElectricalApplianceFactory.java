package tasks.task5_17_11_2017.entities.factories;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

/**Базовый класс фабрик фабричного метода*/
public abstract class ElectricalApplianceFactory {
    public abstract ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException;
}
