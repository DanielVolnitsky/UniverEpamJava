package tasks.task09_05_12_2017.producerConsumer.entities;

import tasks.task09_05_12_2017.producerConsumer.interfaces.StealingCompanion;

public class TruckLoader extends Thread implements StealingCompanion {
    private Street street;
    private Truck truck;
    private ProductCounter productCounter;
    private boolean jobDone;

    public TruckLoader(Street street, Truck truck, ProductCounter productCounter) throws IllegalArgumentException {
        setStreet(street);
        setTruck(truck);
        setProductCounter(productCounter);
    }

    public boolean isJobDone() {
        return jobDone;
    }

    public void setJobDone(boolean jobDone) {
        this.jobDone = jobDone;
    }

    public void setProductCounter(ProductCounter productCounter) {
        if (productCounter != null)
            this.productCounter = productCounter;
        else
            throw new IllegalArgumentException("Считала является null.");
    }

    public void setStreet(Street street) throws IllegalArgumentException {
        if (street != null)
            this.street = street;
        else
            throw new IllegalArgumentException("Улица является null.");
    }

    public void setTruck(Truck truck) throws IllegalArgumentException {
        if (truck != null)
            this.truck = truck;
        else
            throw new IllegalArgumentException("грузовик является null.");
    }

    @Override
    public void run() {
        /*вторая проверка нужна, если соседний поток закончит работу быстрее, чем этот*/
        while (!isJobDone() || street.getCurrProductCount() > 0) {
            street.get();
            truck.put();
        }
        System.out.println("Петров закончил перенос имущества и слинял");
        notifyStockIsEmpty();
        interrupt();
    }

    private void notifyStockIsEmpty() {
        productCounter.setJobDone(true);
    }
}
