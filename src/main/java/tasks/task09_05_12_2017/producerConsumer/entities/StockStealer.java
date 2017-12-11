package tasks.task09_05_12_2017.producerConsumer.entities;

public class StockStealer extends Thread implements StealingCompanion {
    private Stock stock;
    private Street street;
    private TruckLoader truckLoader;
    private boolean jobDone;

    public StockStealer(Stock stock, Street street, TruckLoader truckLoader) {
        this.stock = stock;
        this.street = street;
        this.truckLoader = truckLoader;
    }

    public boolean isJobDone() {
        return jobDone;
    }

    public void setJobDone(boolean jobDone) {
        this.jobDone = jobDone;
    }

    @Override
    public void run() {
        while (stock.getProduct() > 0) {
            stock.get();
            street.put();
        }
        System.out.println("Иванов закончил работу, докладывает об этом подельникам");
        notifyStockIsEmpty();
    }

    private void notifyStockIsEmpty() {
        truckLoader.setJobDone(true);
    }
}
