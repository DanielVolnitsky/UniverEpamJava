package tasks;

import tasks.task5_17_11_2017.entities.ElectricalAppliance;
import tasks.task5_17_11_2017.entities.additional.ElectricalAppliancesHandler;
import tasks.task5_17_11_2017.entities.additional.House;
import tasks.task5_17_11_2017.entities.factories.*;
import tasks.task5_17_11_2017.exceptions.ElectricalApplianceException;

import java.util.List;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class Main {
    public static void main(String[] args) {

        /*Пполучаем фабрики электроприборов нашего города*/
        ElectricalApplianceFactory[] factories = new ElectricalApplianceFactory[]{
                new DrillFactory(), new IronFactory(), new TableLampFactory(), new VacuumCleanerFactory()
        };

        /*Берем с каждой фабрики по электроприбору типа фабрики*/
        ElectricalAppliance[] eAppliances = new ElectricalAppliance[factories.length];
        for (int i = 0; i < eAppliances.length; ) {
            try {
                eAppliances[i] = factories[i].createElectricalAppliance();
                i++;
            } catch (ElectricalApplianceException e) {
                System.err.println("Problem with creating appliance, we will make another one.");
            }
        }

        /*Наш дом*/
        House myHouse = new House();

        /*Коллекция домашних электроприборов*/
        House.ElectricalApplianceCollection homeCollection = myHouse.new ElectricalApplianceCollection();

        /*Добавляем новые приборы в коллекцию*/
        for (ElectricalAppliance eAppliance : eAppliances)
            homeCollection.add(eAppliance);

        System.out.println("All electrical appliances in house:\n\n" + homeCollection.toString());

        /*Вызываем мастера по сортировке и селекции электроприборов и показываем свою коллекцию*/
        ElectricalAppliancesHandler helper = new ElectricalAppliancesHandler(homeCollection.getElectricalAppliances());

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

        ElectricalAppliancesHandler.Ranger<Double> ranger = helper.new Ranger<>();

        String propertyName = "weight";
        double min = 2;
        double max = 10;
        List<ElectricalAppliance> selected = ranger.getAppliancesByParamInRange(propertyName, min, max);

        System.out.println("Electrical Appliances with " + propertyName + " between " + min + " and " + max + ":");
        System.out.println(ElectricalAppliancesHandler.electricalAppliancesToString(selected));
    }
}
