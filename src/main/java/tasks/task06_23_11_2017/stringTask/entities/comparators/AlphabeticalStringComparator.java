package tasks.task06_23_11_2017.stringTask.entities.comparators;

import java.util.Comparator;

/**
 * Компаратор, сравнивающий строки в алфавитном порядке
 */
public class AlphabeticalStringComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
        if (res == 0)
            res = str1.compareTo(str2);

        return res;
    }
}
