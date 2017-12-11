package tasks.task10_07_12_2017;

import tasks.task10_07_12_2017.entities.Parking;
import tasks.task10_07_12_2017.entities.RunnableCar;
import tasks.task10_07_12_2017.entities.RunnableСarFactory;
import tasks.task10_07_12_2017.interfaces.RunnableTransport;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int CARS_NEEDED = 5;

    public static void main(String args[]) {
        System.out.println("Всего машин: " + CARS_NEEDED);

        Parking parking1 = new Parking(2, "'Kyiv parking'");
        Parking parking2 = new Parking(2, "'Irpin Parking'");

        System.out.println();

        LinkedList<Parking> nearbyParkings = new LinkedList<>();
        nearbyParkings.add(parking1);
        nearbyParkings.add(parking2);

        List<RunnableTransport> runnableTransports = new ArrayList<>();

        /*Заполняем список демонстрационных машин*/
        for (int i = 0; i < CARS_NEEDED; i++) {
            RunnableCar runnableCar = new RunnableСarFactory().getRunnableTransport();
            runnableCar.setNearbyParkings(nearbyParkings);
            runnableTransports.add(runnableCar);
        }

        /*Запускаем машины на поиски парковок*/
        for (RunnableTransport runnableTransport : runnableTransports) {
            new Thread(runnableTransport).start();
        }
    }
}
