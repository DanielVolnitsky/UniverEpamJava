package tasks.task10_07_12_2017.entities;

import java.util.concurrent.Semaphore;

public class Parking {
    private String name;
    private Semaphore parkingSlots;

    public Parking(int parkingSlotsCount, String name) throws IllegalArgumentException {
        setParkingSlots(parkingSlotsCount);
        this.name = name;

        System.out.println("Начальное кол-во мест на " + this.name + ": " + this.parkingSlots.availablePermits());
    }

    public Semaphore getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(int parkingSlotsCount) throws IllegalArgumentException {
        if (parkingSlotsCount > -1)
            this.parkingSlots = new Semaphore(parkingSlotsCount, true);
        else
            throw new IllegalArgumentException("Кол-во мест на заправке не может быть отрицательным числом.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
