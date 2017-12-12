package tasks.task09_05_12_2017.beesAndPuch.entities;

public class ForestSegment {
    int segmentIndex;

    public ForestSegment(int segmentIndex) throws IllegalArgumentException {
        setSegmentIndex(segmentIndex);
    }

    public void setSegmentIndex(int segmentIndex) throws IllegalArgumentException {
        if (segmentIndex > -1)
            this.segmentIndex = segmentIndex;
        else
            throw new IllegalArgumentException();
    }
}
