package tasks.task6_23_11_2017.stringTask.entities.comparators;

import java.util.Comparator;


public class AlphabeticalStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
        if (res == 0)
            res = o1.compareTo(o2);

        return res;
    }
}
