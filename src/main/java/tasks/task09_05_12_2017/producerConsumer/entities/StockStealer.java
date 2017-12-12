package tasks.task09_05_12_2017.producerConsumer.entities;

import tasks.task09_05_12_2017.producerConsumer.interfaces.StealingCompanion;

public class StockStealer extends Thread implements StealingCompanion {
    private Stock stock;
    private Street street;
    private TruckLoader truckLoader;
    private boolean jobDone;

    public StockStealer(Stock stock, Street street, TruckLoader truckLoader) throws IllegalArgumentException {
        setStock(stock);
        setStreet(street);
        setTruckLoader(truckLoader);
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) throws IllegalArgumentException {
        if (stock != null)
            this.stock = stock;
        else
            throw new IllegalArgumentException("Склад является null.");
    }

    public void setStreet(Street street) throws IllegalArgumentException {
        if (street != null)
            this.street = street;
        else
            throw new IllegalArgumentException("Улица является null.");
    }

    public void setTruckLoader(TruckLoader truckLoader) throws IllegalArgumentException {
        if (truckLoader != null)
            this.truckLoader = truckLoader;
        else
            throw new IllegalArgumentException("Грузовик является null.");
    }

    public boolean isJobDone() {
        return jobDone;
    }

    public void setJobDone(boolean jobDone) {
        this.jobDone = jobDone;
    }

    @Override
    public void run() {
        while (stock.getProductCount() > 0) {
            stock.get();
            street.put();
        }
        System.out.println("Иванов закончил работу, докладывает об этом ближайшему подельнику");
        notifyStockIsEmpty();
    }

    private void notifyStockIsEmpty() {
        truckLoader.setJobDone(true);
    }
}
