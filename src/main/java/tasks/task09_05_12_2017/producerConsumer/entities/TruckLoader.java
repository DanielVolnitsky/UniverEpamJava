package tasks.task09_05_12_2017.producerConsumer.entities;

public class TruckLoader extends Thread implements StealingCompanion {
    private Street street;
    private Truck truck;
    private ProductCounter productCounter;
    private boolean jobDone;

    public TruckLoader(Street street, Truck truck, ProductCounter productCounter) {
        this.street = street;
        this.truck = truck;
        this.productCounter = productCounter;
    }

    public boolean isJobDone() {
        return jobDone;
    }

    public void setJobDone(boolean jobDone) {
        this.jobDone = jobDone;
    }

    @Override
    public void run() {
        while (!isJobDone() || street.getProduct() > 0) {
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
