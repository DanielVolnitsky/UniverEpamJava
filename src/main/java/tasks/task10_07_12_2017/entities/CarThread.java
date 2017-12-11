package tasks.task10_07_12_2017.entities;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class CarThread extends Thread {
    private int carID;
    private int maxWaitTime;
    private int timeAtParking;
    private LinkedList<Parking> nearbyParkings;
    private boolean needParking;

    {
        needParking = true;
        nearbyParkings = new LinkedList<>();
    }

    public CarThread(int carID, int maxWaitTime, int timeAtParking) {
        this.carID = carID;
        this.maxWaitTime = maxWaitTime;
        this.timeAtParking = timeAtParking;
    }

    public void setNearbyParkings(LinkedList<Parking> nearbyParkings) {
        this.nearbyParkings = nearbyParkings;
    }

    public int getCarId() {
        return carID;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public int getTimeAtParking() {
        return timeAtParking;
    }

    public void setTimeAtParking(int timeAtParking) {
        this.timeAtParking = timeAtParking;
    }

    @Override
    public void run() {
        Iterator<Parking> parkingIterator = nearbyParkings.iterator();
        while (needParking && parkingIterator.hasNext()) {
            Parking parking = parkingIterator.next();
            System.out.println(carID + " подъехала к станции " + parking.getName());
            try {
                if (parking.tryAcquire(maxWaitTime, TimeUnit.MILLISECONDS)) {
                    System.out.println(carID + " заняла место на стоянке " + parking.getName());
                    this.holdParkingPlace();

                    System.out.println("***" + carID + " освобождает место и уезжает по своим делам");
                    needParking = false;
                    parking.release();
                } else {
                    System.out.println(carID + " больше не может ждать и уезжает в поисках другой автостоянки");
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

    private void holdParkingPlace() throws InterruptedException {
        Thread.sleep(timeAtParking);
    }
}
