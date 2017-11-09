package tasks.task2_07_11_2017.entities;

import java.time.Year;

import tasks.task2_07_11_2017.interfaces.MoveAble;

/**Представляет абстракцию машины
 * @see Vehicle
 * @see Car
 * */
public abstract class Car extends Vehicle implements MoveAble {

    public Car(){
        super();
    }

    public Car(double price, double velocity, Year releaseYear, double latitude, double longitude) {
        super(price, velocity, releaseYear, latitude, longitude);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
