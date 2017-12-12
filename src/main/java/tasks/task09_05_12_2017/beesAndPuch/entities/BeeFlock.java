package tasks.task09_05_12_2017.beesAndPuch.entities;

import tasks.exceptions.InvalidIdException;

public class BeeFlock extends Thread {

    private static final int POOH_LOCATION_MARK = 1;

    int flockID;
    Beehive beehive;
    private ForestSegment segmentToGo;

    public BeeFlock(int flockID) throws InvalidIdException {
        setFlockID(flockID);
    }

    public BeeFlock(int flockID, Beehive beehive) throws InvalidIdException {
        this(flockID);
        this.beehive = beehive;
    }

    public void setFlockID(int flockID) throws InvalidIdException {
        if (flockID > -1)
            this.flockID = flockID;
        else
            throw new InvalidIdException();
    }

    public ForestSegment getSegmentToGo() {
        return segmentToGo;
    }

    public void setSegmentToGo(ForestSegment segmentToGo) {
        this.segmentToGo = segmentToGo;
    }

    @Override
    public void run() {
        System.out.println(flockID + " cтая полетела по сегменту: " + segmentToGo.segmentIndex);
        try {
            int forestLength = beehive.getForest().field[0].length - 1;
            for (int j = 0; j < forestLength; j++) {
                if (beehive.getForest().field[segmentToGo.segmentIndex][j] == POOH_LOCATION_MARK) {
                    System.out.println("\n***** " + flockID + " стая нашла цель и наказала Пуха *****\n");
                    beehive.setPoohHasBeenFounded(true);
                }
            }
            beehive.getBeeFlocks().add(this);
            System.out.println(flockID + " стая вернулась в улей");
            interrupt();
        } catch (Exception e) {
            System.out.println("no more segments left");
        }
    }
}
