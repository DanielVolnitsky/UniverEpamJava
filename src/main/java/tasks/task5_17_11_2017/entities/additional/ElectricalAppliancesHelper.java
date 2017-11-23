package tasks.task5_17_11_2017.entities.additional;

import tasks.helpers.ArithmeticHelper;
import tasks.task5_17_11_2017.entities.ElectricalAppliance;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс представляет сущность, занимающуюся сортировкой и выборкой электроприборов
 */
public class ElectricalAppliancesHelper {

    private List<ElectricalAppliance> electricalAppliances;

    {
        electricalAppliances = new ArrayList<>();
    }

    public ElectricalAppliancesHelper(List<ElectricalAppliance> electricalAppliances) {
        this.electricalAppliances = electricalAppliances;
    }

    public static String electricalAppliancesToString(List<ElectricalAppliance> electricalAppliances) {
        StringBuilder result = new StringBuilder();
        for (ElectricalAppliance ea : electricalAppliances) {
            result.append(ea.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public int getOverallPower() {
        int result = 0;
        for (ElectricalAppliance appliance : electricalAppliances)
            result += appliance.getCurrentPower();

        return result;
    }

    public void printSortedElectricalAppliances() {
        Collections.sort(electricalAppliances);
        System.out.println(electricalAppliancesToString(electricalAppliances));
    }

    public class Ranger<T extends Number> {

        public List<ElectricalAppliance> getAppliancesInParamsRange(String propertyName, T minValue, T maxValue) {
            List<ElectricalAppliance> result = new ArrayList<>();

            for (ElectricalAppliance eAppliance : electricalAppliances) {
                Class c = eAppliance.getClass();
                try {
                    Field field = getFieldIfPresent(eAppliance, propertyName);
                    if (field != null) {
                        String fieldType = field.getType().getName();
                        switch (fieldType) {
                            case "double":
                                double value = field.getDouble(eAppliance);
                                if (ArithmeticHelper.isBetweenTwoDouble(value, (Double) minValue, (Double) maxValue)) {
                                    result.add(eAppliance);
                                }
                                break;
                            case "int":
                                if (ArithmeticHelper.isBetweenTwoInt(field.getInt(eAppliance), (Integer) minValue, (Integer) maxValue)) {
                                    result.add(eAppliance);
                                }
                                break;
                            default:
                                continue;
                        }
                    }
                } catch (IllegalAccessException e) {
                    continue;
                }
            }
            return result;
        }

        private Field getFieldIfPresent(ElectricalAppliance eAppliance, String propertyName) {
            Field field = null;
            Class c = eAppliance.getClass();
            while (c.getSuperclass() != Object.class) {
                try {
                    field = c.getDeclaredField(propertyName);
                    if (!field.isAccessible())
                        field.setAccessible(true);
                    return field;
                } catch (NoSuchFieldException e) {
                    c = c.getSuperclass();
                }
            }
            return field;
        }
    }
}
