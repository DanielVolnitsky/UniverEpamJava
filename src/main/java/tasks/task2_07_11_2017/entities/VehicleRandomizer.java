package tasks.task2_07_11_2017.entities;

import java.time.Year;
import java.util.Random;

import static tasks.helpers.ArithmeticHelper.*;

enum VehicleType {
    CAR, PLANE, SHIP, BATMOBILE, AMPHIBIOUSCAR
}

/**
 * Класс предназначен для генерирования случайных объектов типа Vehicle
 */
public class VehicleRandomizer {

    public static Vehicle getRandomVehicle() {

        Random r = new Random();
        int vehiclesTypeCount = VehicleType.values().length;

        return nextVehicle(r.nextInt(vehiclesTypeCount));
    }

    /**
     * @param vehicleTypeOrdinal индекс типа Vehicle в перечислении VehicleType
     * @see VehicleType
     */
    private static Vehicle nextVehicle(int vehicleTypeOrdinal) {

        VehicleType value = VehicleType.values()[vehicleTypeOrdinal];
        switch (value) {
            case CAR:
                return new Car(getRandomizedRoundedDouble(0, 30000, 2),
                        getRandomizedRoundedDouble(0.0, 455.0, 3),
                        Year.of(getRandomizedInt(2000, 2017)), getRandomizedDouble(-90.0, 90.0),
                        getRandomizedDouble(-180.0, 180.0));
            case PLANE:
                return new Plane(getRandomizedRoundedDouble(0, 90000, 2),
                        getRandomizedRoundedDouble(0.0, 2570.0, 3),
                        Year.of(getRandomizedInt(2000, 2017)), getRandomizedInt(0, 100),
                        getRandomizedDouble(-90.0, 90.0), getRandomizedDouble(-180.0, 180.0), getRandomizedInt(0, 12000));
            case SHIP:
                return new Ship(getRandomizedRoundedDouble(0, 90000, 2),
                        getRandomizedRoundedDouble(0.0, 50.0, 3),
                        Year.of(getRandomizedInt(2000, 2017)), getRandomizedInt(0, 1000), "Odessa",
                        getRandomizedDouble(-90.0, 90.0), getRandomizedDouble(-180.0, 180.0));
            case BATMOBILE:
                return new Batmobile(getRandomizedRoundedDouble(10000, 100000, 2), 455.0,
                        Year.of(getRandomizedInt(2000, 2017)),
                        getRandomizedDouble(-90.0, 90.0), getRandomizedDouble(-180.0, 180.0));
            case AMPHIBIOUSCAR:
                return new AmphibiousCar(getRandomizedRoundedDouble(10000, 100000, 2), 400.0,
                        Year.of(getRandomizedInt(2000, 2017)),
                        getRandomizedDouble(-90.0, 90.0), getRandomizedDouble(-180.0, 180.0));
            default:
                return null;
        }
    }
}
