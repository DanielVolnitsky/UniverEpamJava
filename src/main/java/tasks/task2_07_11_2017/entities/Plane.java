package tasks.task2_07_11_2017.entities;

import tasks.task2_07_11_2017.interfaces.FlyAble;

import java.time.Year;


public class Plane extends Vehicle implements FlyAble {
    /**
     * Вместимость; возможное кол-во пассажиров
     */
    private int capacity;
    /**
     * высота над уровнем моря, измеряется в метрах
     */
    private int altitude;

    public Plane() {
        super();
    }

    public Plane(double price, double velocity, Year releaseYear, int capacity, double latitude, double longitude, int altitude) {
        super(price, velocity, releaseYear, latitude, longitude);
        setAltitude(altitude);
        setCapacity(capacity);
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        if (altitude >= 0)
            this.altitude = altitude;
        else
            throw new IllegalArgumentException("altitude has to be a positive value");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity >= 0)
            this.capacity = capacity;
        else
            throw new IllegalArgumentException("capacity has to be a positive value");
    }

    @Override
    public String toString() {
        return "Plane: " + super.toString() +
                ", altitude = " + altitude + "m, capacity = " + capacity;
    }

    public void Fly() {
        System.out.println("flying");
    }
}
