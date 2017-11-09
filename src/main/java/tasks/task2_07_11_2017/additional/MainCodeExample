package tasks;

import tasks.helpers.ArrayHelper;
import tasks.task2_07_11_2017.entities.Plane;
import tasks.task2_07_11_2017.entities.Vehicle;
import tasks.task2_07_11_2017.entities.VehicleFactory;
import tasks.task2_07_11_2017.entities.VehicleSelector;
import tasks.task2_07_11_2017.interfaces.FlyAble;
import tasks.task2_07_11_2017.interfaces.MoveAble;
import tasks.task2_07_11_2017.interfaces.SwimAble;

public class Main {

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle[] vehicles = new Vehicle[8];

        for (int i = 0; i < vehicles.length; i++)
            vehicles[i] = factory.getRandomVehicle();

        System.out.println("Instant array of Vehicles:");
        ArrayHelper.printArray(vehicles);

        Vehicle minPrice = VehicleSelector.getMinPriceVehicle(vehicles);
        System.out.println("\nVehicle with lowest price:\n" + minPrice);

        Vehicle maxSpeed = VehicleSelector.getMaxSpeed(vehicles);
        System.out.println("\nVehicle with highest speed:\n" + maxSpeed);

        Vehicle[] result = new Vehicle[vehicles.length];
        VehicleSelector.fillByNotOlderThan5Years(vehicles, result);
        System.out.println("\nVehicles not older than 5 years:");
        ArrayHelper.printArray(result);

        System.out.println("\nAltitude higher than 5000 and year of release after 2000:");
        Plane[] resultPlanes = new Plane[vehicles.length];
        VehicleSelector.fillByHigherYearAndAltitudePlanes(2000, 5000, vehicles, resultPlanes);
        ArrayHelper.printArray(resultPlanes);

        Vehicle[] ranged = new Vehicle[vehicles.length];
        VehicleSelector.fillByNotPlanesWithVelocityInInRange(200.0, 500.0, vehicles, ranged);
        System.out.println("\nVehicles that are not plane with velocity between 200 and 500:");
        ArrayHelper.printArray(ranged);

        MoveAble[] moveables = new MoveAble[vehicles.length];
        VehicleSelector.fillByMoveAbles(vehicles, moveables);
        System.out.println("\nMoveable:");
        ArrayHelper.printArray(moveables);

        FlyAble[] flyables = new FlyAble[vehicles.length];
        VehicleSelector.fillByFlyAbles(vehicles, flyables);
        System.out.println("\nFlyable:");
        ArrayHelper.printArray(flyables);

        SwimAble[] swimables = new SwimAble[vehicles.length];
        VehicleSelector.fillBySwimAbles(vehicles, swimables);
        System.out.println("\nSwimable:");
        ArrayHelper.printArray(swimables);
    }
}
