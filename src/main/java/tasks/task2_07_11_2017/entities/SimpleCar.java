package tasks.task2_07_11_2017.entities;


import tasks.task2_07_11_2017.interfaces.MoveAble;

import java.time.Year;


/**
 * Класс, представляющий обычную машину
 *
 * @see Car
 */
public class SimpleCar extends Car {

    public SimpleCar() {
        super();
    }

    public SimpleCar(double price, double velocity, Year releaseYear, double latitude, double longitude) {
        super(price, velocity, releaseYear, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Car: " + super.toString();
    }

    public void Move() {
        System.out.println("Moving");
    }
}
