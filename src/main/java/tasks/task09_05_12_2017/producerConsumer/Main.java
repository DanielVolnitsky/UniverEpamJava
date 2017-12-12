package tasks.task09_05_12_2017.producerConsumer;

import tasks.task09_05_12_2017.producerConsumer.entities.*;

public class Main {

    public static void main(String[] args) {
        Stock stock = new Stock(7);
        Street street = new Street(3);
        Truck truck = new Truck(3);

        ProductCounter productCounter = new ProductCounter(truck);
        TruckLoader truckLoader = new TruckLoader(street, truck, productCounter);
        StockStealer stockStealer = new StockStealer(stock, street, truckLoader);

        new Thread(productCounter).start();
        new Thread(truckLoader).start();
        new Thread(stockStealer).start();
    }
}
