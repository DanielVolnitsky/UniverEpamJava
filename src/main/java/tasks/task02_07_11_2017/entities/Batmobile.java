package tasks.task02_07_11_2017.entities;

import tasks.task02_07_11_2017.interfaces.FlyAble;
import tasks.task02_07_11_2017.interfaces.SwimAble;

import java.time.Year;

public class Batmobile extends Car implements FlyAble, SwimAble {

    public Batmobile() {
    }

    public Batmobile(double price, double velocity, Year releaseYear, double latitude, double longitude) {
        super(price, velocity, releaseYear, latitude, longitude);
    }

    public void Fly() {
        System.out.println("flying");
    }

    public void Move() {
        super.Move();
        System.out.println(", but faster");
    }

    public void Swim() {
        System.out.println("swimming");
    }

    public String toString() {
        return "Batmobile: " + super.toString();
    }
}
