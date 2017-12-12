package tasks.task09_05_12_2017.producerConsumer.entities;

public class Stock {
    /*продукты представлены обычными числами*/
    private int productCount;

    public Stock(int productCount) throws IllegalArgumentException {
        setProductCount(productCount);
        System.out.println("Изначально товаров на складе: " + productCount);
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) throws IllegalArgumentException {
        if (productCount > -1)
            this.productCount = productCount;
        else
            throw new IllegalArgumentException("Кол-во вещей на складе не должно быть меньше нуля");

    }

    public synchronized void get() {
        if (productCount > 0) {
            productCount--;
            System.out.println("Иванов стащил товар");
            System.out.println("Товаров на складе: " + productCount);
        }
    }
}
