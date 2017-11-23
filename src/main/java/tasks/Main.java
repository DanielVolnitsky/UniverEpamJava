package tasks;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.additional.ElectricalAppliancesHelper;
import tasks.task5_17_11_2017.entities.additional.House;
import tasks.task5_17_11_2017.entities.factories.*;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import java.util.List;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class Main {
    public static void main(String[] args) {

        ElectricalApplianceFactory[] factories = new ElectricalApplianceFactory[]{
                new DrillFactory(), new IronFactory(), new TableLampFactory(), new VacuumCleanerFactory()
        };

        ElectricalAppliance[] eAppliances = new ElectricalAppliance[factories.length];
        for (int i = 0; i < eAppliances.length; ) {
            try {
                eAppliances[i] = factories[i].createElectricalAppliance();
                i++;
            } catch (ElectricalApplianceException e) {
                System.err.println("Problem with creating appliance, we will make another one.");
            }
        }

        House myHouse = new House();
        House.ElectricalApplianceCollection homeCollection = myHouse.new ElectricalApplianceCollection();

        for (ElectricalAppliance eAppliance : eAppliances)
            homeCollection.add(eAppliance);

        System.out.println("All electrical appliances in house:\n\n" + homeCollection.toString());

        ElectricalAppliancesHelper helper = new ElectricalAppliancesHelper(homeCollection.getElectricalAppliances());

        System.out.println("Now we plug in some of them.\n");

        /*Случайным образом включаем некоторые устройства*/
        for (ElectricalAppliance appliance : homeCollection.getElectricalAppliances()) {
            int randNum = getRandomizedInt(0, 2);
            if (randNum == 0)
                appliance.switchOn();
        }

        System.out.println("\nOverall power at this time: " + helper.getOverallPower() + " Vatt");

        System.out.println("\nSorted by power: ");
        helper.printSortedElectricalAppliances();

        ElectricalAppliancesHelper.Ranger<Integer> ranger = helper.new Ranger<>();

        String propertyName = "currentPower";
        int min = 1;
        int max = 2000;
        List<ElectricalAppliance> selected = ranger.getAppliancesInParamsRange(propertyName, min, max);

        System.out.println("Electrical Appliances with " + propertyName + " between " + min + " and " + max + ":");
        System.out.println(ElectricalAppliancesHelper.electricalAppliancesToString(selected));
    }
}
