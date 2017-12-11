package tasks.task06_23_11_2017.regexTask.entities;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordFrequencyHelper {
    /**
     * @param initialMap начальный несортированный map
     * @return связный map, сортированный по частоте вхождения слова
     */
    static Map<String, Map<String, Integer>> getMapSortedByWordFrequency(Map<String, Map<String, Integer>> initialMap, String seekWord) {
        WordFrequencyMapComparator comparator = new WordFrequencyMapComparator(seekWord);
        return initialMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

//    public static <K, V extends Comparable<? super V>> Map<K, V>
//    sortByValue(Map<K, V> map) {
//        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
//        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
//            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
//                return (o1.getValue()).compareTo( o2.getValue() );
//            }
//        });
//
//        Map<K, V> result = new LinkedHashMap<K, V>();
//        for (Map.Entry<K, V> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }
//        return result;
//    }

    /**
     * @param urlWordsMap    map слово - кол-во его вхождения
     * @param neededUrlCount максимальное кол-во нужных url
     */
    static void iterateUrlsAndFillWordsFrequencies(List<String> urls, Map<String, Map<String, Integer>> urlWordsMap, byte neededUrlCount) {
        for (int i = 0; i < urls.size() && urlWordsMap.size() <= neededUrlCount; i++) {
            String url = urls.get(i);
            try {
                String text = new SiteInfoHelper(url).getSiteBodyText();

                Map<String, Integer> wordsWithFrequency = new HashMap<>();
                WordFrequencyHelper.fillWordsFrequencyMap(wordsWithFrequency, text);

                if (wordsWithFrequency.size() > 0) {
                    System.out.println(String.format("Working with (%s) url...", url));

                    if (!urlWordsMap.containsKey(url)) {
                        urlWordsMap.put(url, wordsWithFrequency);
                    } else {
                        System.err.println("Этот url уже присутствует в списке: " + url);
                    }
                }
            } catch (IOException ex) {
                //place for logging
            }
        }
    }

    static void fillWordsFrequencyMap(Map<String, Integer> map, String text) {
        String[] words = text.split("[\\W\\d]");
        int wordsMinLength = 3;
        for (String word : words) {
            if (word.length() >= wordsMinLength) {
                Integer freq = map.get(word);
                map.put(word, (freq == null) ? 1 : freq + 1);
            }
        }
    }
}
