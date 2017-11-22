package tasks;


import com.sun.org.apache.xpath.internal.SourceTree;
import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.additional.ElectricalAppliancesHelper;
import tasks.task5_17_11_2017.entities.additional.House;
import tasks.task5_17_11_2017.entities.factoryMethod.*;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import java.util.List;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class Main {
    public static void main(String[] args) {

        ElectricalApplianceFactory[] factories = new ElectricalApplianceFactory[]{
                new DrillFactory(), new IronFactory(), new TableLampFactory(), new VacuumCleanerFactory()
        };

        ElectricalAppliance[] eAppliances = new ElectricalAppliance[10];
        for (int i = 0; i < eAppliances.length; ) {
            int randIndex = getRandomizedInt(0, factories.length);
            try {
                eAppliances[i] = factories[randIndex].createElectricalAppliance();
                i++;
            } catch (ElectricalApplianceException e) {
                System.err.println("Problem with creating appliance, we will make another one.");
            }
        }

        House myHouse = new House();
        House.ElectricalApplianceCollection eaCollection = myHouse.new ElectricalApplianceCollection();

        for (ElectricalAppliance ea : eAppliances)
            eaCollection.add(ea);

        System.out.println("All electrical appliances in house:\n" + eaCollection.toString());

        ElectricalAppliancesHelper helper = new ElectricalAppliancesHelper(eaCollection.getElectricalAppliances());

        System.out.println("Now we plug in some of them.");

        /*Случайным образом включаем некоторые устройства а розетку*/
        for (ElectricalAppliance appliance : eaCollection.getElectricalAppliances()) {
            int randNum = getRandomizedInt(0, 2);
            if (randNum == 0)
                appliance.plugIn();
        }

        System.out.println("Overall power at this time: " + helper.getOverallPower() + " Vatt");

        System.out.println("\nSorted by power: ");
        helper.printSortedElectricalAppliances();

        List<ElectricalAppliance> selected = helper.getAppliancesInVoltageAndAmperageRange(
                0, 555, 0, 1000);

        System.out.println("In range:");
        System.out.println(ElectricalAppliancesHelper.electricalAppliancesToString(selected));
    }
}
