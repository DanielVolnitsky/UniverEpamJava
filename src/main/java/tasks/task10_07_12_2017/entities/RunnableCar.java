package tasks.task10_07_12_2017.entities;

import tasks.exceptions.InvalidIdException;
import tasks.exceptions.InvalidTimeValueException;
import tasks.task10_07_12_2017.interfaces.RunnableTransport;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class RunnableCar implements RunnableTransport {
    private int carID;
    private int maxWaitTime;
    private int timeAtParking;
    /*Список ближайших парковок*/
    private LinkedList<Parking> nearbyParkings;
    /*true - если необходима стоянка*/
    private boolean needParking;

    {
        needParking = true;
        nearbyParkings = new LinkedList<>();
    }

    public RunnableCar(int carID, int maxWaitTime, int timeAtParking) throws InvalidIdException, InvalidTimeValueException {
        setCarID(carID);
        setMaxWaitTime(maxWaitTime);
        setTimeAtParking(timeAtParking);
    }

    public void setNearbyParkings(LinkedList<Parking> nearbyParkings) {
        this.nearbyParkings = nearbyParkings;
    }

    public int getCarId() {
        return carID;
    }

    private void setCarID(int carID) throws InvalidIdException {
        if (carID > 0)
            this.carID = carID;
        else
            throw new InvalidIdException();
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(int maxWaitTime) throws InvalidTimeValueException {
        if (maxWaitTime > 0)
            this.maxWaitTime = maxWaitTime;
        else
            throw new InvalidTimeValueException();
    }

    public int getTimeAtParking() {
        return timeAtParking;
    }

    public void setTimeAtParking(int timeAtParking) throws InvalidTimeValueException {
        if (timeAtParking > 0)
            this.timeAtParking = timeAtParking;
        else
            throw new InvalidTimeValueException();
    }

    @Override
    public void run() {
        Iterator<Parking> parkingIterator = nearbyParkings.iterator();
        while (needParking && parkingIterator.hasNext()) {
            Parking parking = parkingIterator.next();
            System.out.println(carID + " подъехала к станции " + parking.getName() + "и ждет " + maxWaitTime + " мс");
            try {
                /*Пытаемся получить место, ожидая столько, сколько указано в машине*/
                if (parking.getParkingSlots().tryAcquire(maxWaitTime, TimeUnit.MILLISECONDS)) {
                    System.out.println(carID + " заняла место на стоянке " + parking.getName());
                    this.holdParkingPlace();

                    System.out.println("***" + carID + " освобождает место и уезжает по своим делам");

                    needParking = false;
                    parking.getParkingSlots().release();
                } else {
                    System.out.println(carID + " больше не может ждать и уезжает в поисках другой автостоянки");
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

    /*Метод стояния на парковочном месте*/
    private void holdParkingPlace() throws InterruptedException {
        Thread.sleep(timeAtParking);
    }
}
