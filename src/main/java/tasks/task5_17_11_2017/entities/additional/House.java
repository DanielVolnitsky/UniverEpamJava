package tasks.task5_17_11_2017.entities.additional;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет поверхостную реализацию сущности дом
 */
public class House {

    public House() {

    }

    /**
     * Класс представляет коллекцию домашних электроприборов
     */
    public class ElectricalApplianceCollection {
        List<ElectricalAppliance> electricalAppliances;

        {
            electricalAppliances = new ArrayList<ElectricalAppliance>();
        }

        public ElectricalApplianceCollection() {

        }

        public void add(ElectricalAppliance electricalAppliance) {
            if (electricalAppliance != null)
                this.electricalAppliances.add(electricalAppliance);
        }

        public void remove(ElectricalAppliance electricalAppliance) {
            if (this.electricalAppliances.size() > 0)
                remove(electricalAppliance);
        }

        public List<ElectricalAppliance> getElectricalAppliances() {
            return electricalAppliances;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (ElectricalAppliance ea : electricalAppliances) {
                result.append(ea.toString());
                result.append("\n");
            }
            return result.toString();
        }
    }
}
