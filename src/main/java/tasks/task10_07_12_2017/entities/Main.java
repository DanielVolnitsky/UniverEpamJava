package tasks.task10_07_12_2017.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int CARS_NEEDED = 5;

    public static void main(String args[]) {
        System.out.println("Всего машин: " + CARS_NEEDED);
        Parking parking1 = new Parking(2, true, "'Kyiv parking'");
        Parking parking2 = new Parking(2, true, "'Irpin Parking'");

        System.out.println();

        LinkedList<Parking> nearbyParkings = new LinkedList<>();
        nearbyParkings.add(parking1);
        nearbyParkings.add(parking2);

        List<CarThread> cars = new ArrayList<>();

        for (int i = 0; i < CARS_NEEDED; i++) {
            CarThread car = СarThreadFactory.getNextCar();
            car.setNearbyParkings(nearbyParkings);
            cars.add(car);
        }

        for (CarThread car : cars) {
            car.start();
        }
    }
}
