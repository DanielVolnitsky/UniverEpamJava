package tasks.task6_23_11_2017.regexTask.entities;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordFrequencyHelper {

    static Map<String, Map<String, Integer>> getMapSortedByWordFrequency(Map<String, Map<String, Integer>> initialMap, String seekWord) {
        WordFrequencyMapComparator comparator = new WordFrequencyMapComparator(seekWord);
        return initialMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    static void iterateUrlsAndFillWordsFrequencies(List<String> urls, Map<String, Map<String, Integer>> urlWordsMap, byte neededUrlCount) {
        for (int i = 0; i < urls.size() && urlWordsMap.size() <= neededUrlCount; i++) {
            String url = urls.get(i);
            try {
                System.out.println(String.format("Working with (%s) url...", url));

                String text = SiteInfoHelper.getSiteBodyText(url);

                Map<String, Integer> wordsWithFrequency = new HashMap<>();
                WordFrequencyHelper.fillWordsFrequencyMap(wordsWithFrequency, text);

                if (wordsWithFrequency.size() > 0) {
                    if (!urlWordsMap.containsKey(url)) {
                        urlWordsMap.put(url, wordsWithFrequency);
                    } else {
                        System.err.println("Этот url уже присутствует в списке: " + url);
                    }
                } else {
                    System.err.println("Ни одного слова по заданному url.");
                }
            } catch (IOException ex) {
                System.out.println("failed to open connection with url: " + url);
            }
        }
    }

    private static void fillWordsFrequencyMap(Map<String, Integer> map, String text) {
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
