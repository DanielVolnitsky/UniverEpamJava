package tasks.task02_07_11_2017.entities;

import tasks.task02_07_11_2017.interfaces.SwimAble;

import java.time.Year;

public class AmphibiousCar extends Car implements SwimAble {

    public AmphibiousCar() {

    }

    public AmphibiousCar(double price, double velocity, Year releaseYear, double latitude, double longitude) {
        super(price, velocity, releaseYear, latitude, longitude);
    }

    public String toString() {
        return "AmphibiousCar: " + super.toString();
    }

    public void Swim() {
        System.out.println("swimming");
    }
}
