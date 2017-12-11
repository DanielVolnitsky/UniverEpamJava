package tasks.task05_17_11_2017.entities.factories;

import tasks.task05_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task05_17_11_2017.exceptions.ElectricalApplianceException;

/**Базовый класс фабрик фабричного метода*/
public abstract class ElectricalApplianceFactory {
    public abstract ElectricalAppliance createElectricalAppliance() throws ElectricalApplianceException;
}
