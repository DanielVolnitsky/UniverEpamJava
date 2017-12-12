package tasks.task09_05_12_2017.producerConsumer.entities;

import tasks.task09_05_12_2017.producerConsumer.interfaces.StealingCompanion;

public class ProductCounter extends Thread implements StealingCompanion {
    private Truck truck;
    private boolean jobDone;

    public ProductCounter(Truck truck) throws IllegalArgumentException {
        setTruck(truck);
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) throws IllegalArgumentException {
        if (truck != null)
            this.truck = truck;
        else
            throw new IllegalArgumentException("один из парметров является null.");
    }


    public boolean isJobDone() {
        return jobDone;
    }

    public void setJobDone(boolean jobDone) {
        this.jobDone = jobDone;
    }

    @Override
    public void run() {
         /*вторая проверка нужна, если соседний поток закончит работу быстрее, чем этот*/
        while (!isJobDone() || truck.getUnaccountedProducts() > 0) {
            truck.get();
        }
        System.out.println("Нечепорчук закончил подсчет имущества и слинял");
        interrupt();
    }
}
