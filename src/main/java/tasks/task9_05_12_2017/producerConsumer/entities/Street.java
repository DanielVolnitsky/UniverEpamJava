package tasks.task9_05_12_2017.producerConsumer.entities;

public class Street {

    private int product = 0;
    private int maxProductPresented = 5;

    public int getProduct() {
        return product;
    }

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        product--;
        System.out.println("Петров взял с улицы товар");
        System.out.println("Товаров на улице: " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= maxProductPresented) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        product++;
        System.out.println("Иванов выложил товар на улице");
        System.out.println("Товаров на улице: " + product);
        notify();
    }
}
