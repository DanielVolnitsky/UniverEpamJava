package tasks.task09_05_12_2017.producerConsumer.entities;

public class ProductCounter extends Thread implements StealingCompanion {
    private Truck truck;
    private boolean jobDone;

    public ProductCounter(Truck truck) {
        this.truck = truck;
    }

    public boolean isJobDone() {
        return jobDone;
    }

    public void setJobDone(boolean jobDone) {
        this.jobDone = jobDone;
    }

    @Override
    public void run() {
        while (!isJobDone() || truck.getProduct() > 0) {
            truck.get();
        }
        System.out.println("Нечепорчук закончил подсчет имущества и слинял");
        interrupt();
    }
}
