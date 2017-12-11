package tasks.task9_05_12_2017.beesAndPuch.entities;

public class BeeFlock extends Thread {

    private static int POOH_LOCATION = 1;
    int flockID;
    Beehive beehive;
    private ForestSegment segmentToGo;

    public BeeFlock(int flockID, Beehive beehive) {
        this.flockID = flockID;
        this.beehive = beehive;
    }

    public BeeFlock(int flockID) {
        this.flockID = flockID;
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
            int lengtsh = beehive.getForest().field[0].length - 1;
            for (int j = 0; j < lengtsh; j++) {
                if (beehive.getForest().field[segmentToGo.segmentIndex][j] == POOH_LOCATION) {
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
