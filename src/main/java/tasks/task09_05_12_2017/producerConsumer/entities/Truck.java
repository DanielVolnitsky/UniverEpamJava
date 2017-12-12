package tasks.task09_05_12_2017.producerConsumer.entities;

public class Truck {
    /*неподсчитаных товаров*/
    private int unaccountedProducts = 0;
    /*макс. кол-во одновременно находящихся предметов*/
    private int maxUnaccountedPossible;

    public Truck(int maxUnaccountedPossible) throws IllegalArgumentException{
        setMaxUnaccountedPossible(maxUnaccountedPossible);
    }

    public void setMaxUnaccountedPossible(int maxUnaccountedPossible) throws IllegalArgumentException{
        if ( maxUnaccountedPossible > -1)
            this. maxUnaccountedPossible =  maxUnaccountedPossible;
        else
            throw new IllegalArgumentException("Кол-во вещей в грузовике не должно быть меньше нуля");
    }

    public int getUnaccountedProducts() {
        return unaccountedProducts;
    }

    public synchronized void get() {
        while (unaccountedProducts < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        unaccountedProducts--;
        System.out.println("Нечепорчук взял товар для подсчета");
        System.out.println("Неподсчитанных товаров в грузовике: " + unaccountedProducts);
        notify();
    }

    public synchronized void put() {
        while (unaccountedProducts >= maxUnaccountedPossible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        unaccountedProducts++;
        System.out.println("Петров добавил товар в грузовик");
        System.out.println("Неподсчитанных товаров в грузовике: " + unaccountedProducts);
        notify();
    }

}
