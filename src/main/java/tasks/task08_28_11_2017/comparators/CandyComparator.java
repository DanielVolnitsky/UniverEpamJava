package tasks.task08_28_11_2017.comparators;

import tasks.task08_28_11_2017.entities.Candy;

import java.util.Comparator;

/*compares by candy type*/
public class CandyComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        return o1.getCandyType().compareTo(o2.getCandyType());
    }
}
