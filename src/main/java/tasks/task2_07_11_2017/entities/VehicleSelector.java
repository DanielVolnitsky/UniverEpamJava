package tasks.task2_07_11_2017.entities;

import tasks.task2_07_11_2017.interfaces.FlyAble;
import tasks.task2_07_11_2017.interfaces.MoveAble;
import tasks.task2_07_11_2017.interfaces.SwimAble;

import java.time.Year;

/**
 * Класс служит для выборки наследников класса Vehicle по некоторым критериям
 *
 * @see Vehicle
 */
public class VehicleSelector {

    /**
     * Находит механизм с наименьшей ценой
     */
    public static Vehicle getMinPriceVehicle(Vehicle[] vehicles) {
        if (vehicles.length > 0) {
            Vehicle result = vehicles[0];
            for (int i = 1; i < vehicles.length; i++) {
                if (Double.compare(vehicles[i].getPrice(), result.getPrice()) == -1)
                    result = vehicles[i];
            }
            return result;
        }
        return null;
    }

    /**
     * Находит механизм с наибольшей скоростью
     */
    public static Vehicle getMaxSpeed(Vehicle[] vehicles) {
        if (vehicles.length > 0) {
            Vehicle result = vehicles[0];
            for (int i = 1; i < vehicles.length; i++) {
                if (Double.compare(vehicles[i].getVelocity(), result.getVelocity()) == 1)
                    result = vehicles[i];
            }
            return result;
        }
        return null;
    }

    /**
     * Находит механизмы не старше 5 лет*
     *
     * @param result - результирующий массив в результате выборки
     */
    public static void fillByNotOlderThan5Years(Vehicle[] vehicles, Vehicle[] result) {
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            if (Year.now().getValue() - vehicles[i].getReleaseYear().getValue() <= 5)
                result[j++] = vehicles[i];
        }
    }

    /**
     * Находит из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000*
     *
     * @param result - результирующий массив в результате выборки
     */
    public static void fillByHigherYearAndAltitudePlanes(int year, int altitude, Vehicle[] vehicles, Plane[] result) {
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            if (vehicles[i].getClass() == Plane.class) {
                Plane currPlane = (Plane) vehicles[i];
                if (currPlane.getAltitude() > altitude && currPlane.getReleaseYear().getValue() > year)
                    result[j++] = currPlane;
            }
        }
    }

    /**
     * Находит механизмы с максимальной скоростью в диапазоне, но не Plane*
     *
     * @param min - минимальная скорость
     * @param max - максимальная скорость
     */
    public static void fillByNotPlanesWithVelocityInInRange(double min, double max, Vehicle[] vehicles, Vehicle[] result) {
        Vehicle current;
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            if (vehicles[i].getClass() != Plane.class) {
                current = vehicles[i];
                if (Double.compare(min, current.getVelocity()) == -1 &&
                        Double.compare(max, current.getVelocity()) == 1)
                    result[j++] = current;
            }
        }
    }

    /**
     * Находит из механизмов только те, которые могут ездить по суше*
     *
     * @param result - результирующий массив в результате выборки
     */
    public static void fillByMoveAbles(Vehicle[] vehicles, MoveAble[] result) {
        Vehicle current;
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            current = vehicles[i];
            if (current instanceof MoveAble)
                result[j++] = (MoveAble) current;
        }
    }

    /**
     * Находит из механизмов только те, которые могут лететь*
     *
     * @param result - результирующий массив в результате выборки
     */
    public static void fillByFlyAbles(Vehicle[] vehicles, FlyAble[] result) {
        Vehicle current;
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            current = vehicles[i];
            if (current instanceof FlyAble)
                result[j++] = (FlyAble) current;
        }
    }

    /**
     * Находит из механизмов только те, которые могут плыть*
     *
     * @param result - результирующий массив в результате выборки
     */
    public static void fillBySwimAbles(Vehicle[] vehicles, SwimAble[] result) {
        Vehicle current;
        for (int i = 0, j = 0; i < vehicles.length; i++) {
            current = vehicles[i];
            if (current instanceof SwimAble)
                result[j++] = (SwimAble) current;
        }
    }
}
