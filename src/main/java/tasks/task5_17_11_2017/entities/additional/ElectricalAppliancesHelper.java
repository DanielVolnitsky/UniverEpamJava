package tasks.task5_17_11_2017.entities.additional;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static tasks.helpers.ArithmeticHelper.isBetweenTwoInt;

public class ElectricalAppliancesHelper {

    private List<ElectricalAppliance> electricalAppliances;

    {
        electricalAppliances = new ArrayList<>();
    }

    public ElectricalAppliancesHelper(List<ElectricalAppliance> electricalAppliances) {
        this.electricalAppliances = electricalAppliances;
    }

    public int getOverallPower() {
        int result = 0;
        for (ElectricalAppliance appliance : electricalAppliances) {
            if (appliance.isSwitchedOn())
                result += appliance.getPower();
        }
        return result;
    }

    public void printSortedElectricalAppliances() {
        Collections.sort(electricalAppliances);
        System.out.println(electricalAppliancesToString(electricalAppliances));
    }

    public static String electricalAppliancesToString(List<ElectricalAppliance> electricalAppliances) {
        StringBuilder result = new StringBuilder();
        for (ElectricalAppliance ea : electricalAppliances) {
            result.append(ea.toString());
            result.append("\n");
        }
        return result.toString();
    }

//    public List<ElectricalAppliance> getAppliancesInVoltageAndAmperageRange(
//            int minVoltage, int maxVoltage, int minAmperage, int maxAmperage) {
//
//        List<ElectricalAppliance> result = new ArrayList<>();
//        for (ElectricalAppliance a : electricalAppliances) {
//            if (isBetweenTwoInt(a.getVoltage(), minVoltage, maxVoltage)
//                    && isBetweenTwoInt(a.getAmperage(), minAmperage, maxAmperage)) {
//                result.add(a);
//            }
//        }
//        return result;
//    }
}
