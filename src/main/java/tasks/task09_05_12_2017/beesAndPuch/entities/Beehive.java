package tasks.task09_05_12_2017.beesAndPuch.entities;

import tasks.exceptions.InvalidIdException;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Beehive {
    private int beeFlockCount;
    private BlockingQueue<BeeFlock> beeFlocks;

    private Forest forest;
    private Queue<ForestSegment> forestSegments;

    private boolean poohHasBeenFounded;

    public Beehive(int beeFlockCount, Forest forest) {
        setBeeFlockCount(beeFlockCount);
        setForest(forest);

        beeFlocks = new ArrayBlockingQueue<>(beeFlockCount);
        forestSegments = new ArrayDeque<>(forest.length);

        initializeBeeFlockQueue();
        initializeForestSegments();
    }

    public void setBeeFlockCount(int beeFlockCount) throws IllegalArgumentException {
        if (beeFlockCount > -1)
            this.beeFlockCount = beeFlockCount;
        else
            throw new IllegalArgumentException("Количество стай не может быть отрицательным.");
    }

    public Queue<BeeFlock> getBeeFlocks() {
        return beeFlocks;
    }

    public boolean isPoohHasBeenFounded() {

        return poohHasBeenFounded;
    }

    public void setPoohHasBeenFounded(boolean poohHasBeenFounded) {
        this.poohHasBeenFounded = poohHasBeenFounded;
    }

    public Forest getForest() {
        return forest;
    }

    public void setForest(Forest forest) throws IllegalArgumentException {
        if (forest != null)
            this.forest = forest;
        else
            throw new IllegalArgumentException("Лес не должен быть null.");
    }

    public Queue<ForestSegment> getForestSegments() {
        return forestSegments;
    }


    private void initializeForestSegments() {
        for (int i = 0; i < forest.length; i++) {
            forestSegments.add(new ForestSegment(i));
        }
    }

    /*Симуляция создания роев пчел*/
    private void initializeBeeFlockQueue() {
        for (int i = 1; i <= beeFlockCount; i++) {
            try {
                beeFlocks.add(new BeeFlock(i, this));
            } catch (InvalidIdException e) {
                //logging
            }
        }
    }

    public void findPooh() {
        while (!poohHasBeenFounded && !forestSegments.isEmpty()) {
            try {
                BeeFlock beeFlock = beeFlocks.take();
                beeFlock.setSegmentToGo(forestSegments.poll());
                new Thread(beeFlock).start();
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            }
        }
    }
}
