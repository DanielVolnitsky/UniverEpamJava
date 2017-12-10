package tasks.task9_05_12_2017.producerConsumer.entities;

public class Truck {
    private int product = 0;
    private int maxProductPresented = 3;

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
        System.out.println("Нечепорчук взял товар для подсчета");
        System.out.println("Неподсчитанных товаров в грузовике: " + product);
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
        System.out.println("Петров добавил товар в грузовик");
        System.out.println("Неподсчитанных товаров в грузовике: " + product);
        notify();
    }

}
