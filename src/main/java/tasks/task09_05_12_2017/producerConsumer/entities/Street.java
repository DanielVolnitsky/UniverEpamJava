package tasks.task09_05_12_2017.producerConsumer.entities;

public class Street {

    private int currProductCount = 0;
    /*макс. кол-во одновременно находящихся предметов*/
    private int maxProductPresented = 5;

    public Street(int maxProductPresented) throws IllegalArgumentException {
        setMaxProductPresented(maxProductPresented);
    }

    public void setMaxProductPresented(int maxProductPresented) {
        if (maxProductPresented > -1)
            this.maxProductPresented = maxProductPresented;
        else
            throw new IllegalArgumentException("Кол-во вещей на улице не должно быть меньше нуля");
    }

    public int getCurrProductCount() {
        return currProductCount;
    }

    public synchronized void get() {
        while (currProductCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        currProductCount--;
        System.out.println("Петров взял с улицы товар");
        System.out.println("Товаров на улице: " + currProductCount);
        notify();
    }

    public synchronized void put() {
        while (currProductCount >= maxProductPresented) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        currProductCount++;
        System.out.println("Иванов выложил товар на улице");
        System.out.println("Товаров на улице: " + currProductCount);
        notify();
    }
}
