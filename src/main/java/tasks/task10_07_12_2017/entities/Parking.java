package tasks.task10_07_12_2017.entities;

import tasks.task10_07_12_2017.interfaces.RunnableTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Parking {
    private String name;
    private List<RunnableTransport> currentClientRunnableTransports;
    private Semaphore parkingSlots;

    {
        currentClientRunnableTransports = new ArrayList<>();
    }

    public Parking(int parkingSlotsCount, String name) {
        this.parkingSlots = new Semaphore(parkingSlotsCount, true);
        this.name = name;

        System.out.println("Начальное кол-во мест на " + this.name + ": " + this.parkingSlots.availablePermits());
    }

    public Semaphore getParkingSlots() {
        return parkingSlots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RunnableTransport> getCurrentClientRunnableTransports() {
        return currentClientRunnableTransports;
    }

    public void setCurrentClientRunnableTransports(List<RunnableTransport> currentClientRunnableTransports) {
        this.currentClientRunnableTransports = currentClientRunnableTransports;
    }
}
