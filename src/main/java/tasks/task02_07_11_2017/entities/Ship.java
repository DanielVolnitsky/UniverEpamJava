package tasks.task02_07_11_2017.entities;

import tasks.task02_07_11_2017.interfaces.SwimAble;

import java.time.Year;


public class Ship extends Vehicle implements SwimAble {
    /**
     * Вместимость; возможное кол-во пассажиров
     */
    private int capacity;
    /**
     * Название порта приписки
     */
    private String homePort;

    public Ship() {
        super();
    }

    public Ship(double price, double velocity, Year releaseYear, int capacity, String homePort, double latitude, double longitude) {
        super(price, velocity, releaseYear, latitude, longitude);
        setCapacity(capacity);
        this.homePort = homePort;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity >= 0)
            this.capacity = capacity;
        else
            throw new IllegalArgumentException("capacity has to be MainCodeExample positive value");
    }

    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    @Override
    public String toString() {
        return "Ship: " + super.toString() + " capacity = " + capacity + ", homePort = '" + homePort + '\'';
    }

    public void Swim() {
        System.out.println("Swimming");
    }
}
