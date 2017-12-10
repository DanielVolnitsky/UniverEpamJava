package tasks.task9_05_12_2017.producerConsumer.entities;

public class Stock {
    private int product;

    public Stock(int product) {
        this.product = product;
        System.out.println("Изначально товаров на складе: " + product);
    }

    public int getProduct() {
        return product;
    }

    public synchronized void get() {
       if(product > 0){
           product--;
           System.out.println("Иванов стащил товар");
           System.out.println("Товаров на складе: " + product);
       }
    }
}
