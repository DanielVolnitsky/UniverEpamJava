package tasks.task10_07_12_2017.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Parking extends Semaphore {
    private String name;
    private List<CarThread> currentClientCars;

    {
        currentClientCars = new ArrayList<>();
    }

    public Parking(int permits, boolean fair, String name) {
        super(permits, fair);
        this.name = name;

        System.out.println("Начальное кол-во мест на " + this.name + ": " + this.availablePermits());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarThread> getCurrentClientCars() {
        return currentClientCars;
    }

    public void setCurrentClientCars(List<CarThread> currentClientCars) {
        this.currentClientCars = currentClientCars;
    }
}
