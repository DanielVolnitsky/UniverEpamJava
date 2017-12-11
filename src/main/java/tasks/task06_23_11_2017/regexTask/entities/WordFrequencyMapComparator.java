package tasks.task06_23_11_2017.regexTask.entities;

import java.util.Comparator;
import java.util.Map;

/**
 * Компаратор сравнивает две map по частоте появления в них искомого слова
 */
public class WordFrequencyMapComparator implements Comparator<Map<String, Integer>> {

    private String word;

    public WordFrequencyMapComparator(String word) {
        this.word = word;
    }

    @Override
    public int compare(Map<String, Integer> map1, Map<String, Integer> map2) {
        int firstMapWordFrequency = getMapWordFrequency(map1, word);
        int secMapWordFrequency = getMapWordFrequency(map2, word);

        return firstMapWordFrequency - secMapWordFrequency;
    }

    private int getMapWordFrequency(Map<String, Integer> map, String word) {
        if (map.containsKey(word))
            return map.get(word);
        return 0;
    }
}
