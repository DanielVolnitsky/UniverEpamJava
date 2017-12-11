package tasks.task9_05_12_2017.beesAndPuch.entities;

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
        this.beeFlockCount = beeFlockCount;
        this.forest = forest;
        beeFlocks = new ArrayBlockingQueue<>(beeFlockCount);
        forestSegments = new ArrayDeque<>(forest.length);

        initializeBeeFlockQueue();
        initializeForestSegments();
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

    public Queue<ForestSegment> getForestSegments() {
        return forestSegments;
    }


    private void initializeForestSegments() {
        for (int i = 0; i < forest.length; i++) {
            forestSegments.add(new ForestSegment(i));
        }
    }

    private void initializeBeeFlockQueue() {
        for (int i = 1; i <= beeFlockCount; i++) {
            beeFlocks.add(new BeeFlock(i, this));
        }
    }

    public void findPooh() {
        while (!poohHasBeenFounded && !forestSegments.isEmpty()) {
            try {
                BeeFlock beeFlock = beeFlocks.take();
                beeFlock.setSegmentToGo(forestSegments.poll());
                System.out.println(beeFlock.flockID + " стая вылетела по сегменту " + beeFlock.getSegmentToGo().segmentIndex);
                new Thread(beeFlock).start();
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
