package tasks.task6_23_11_2017.regexTask.entities;

import tasks.helpers.Demonstrator;

import java.io.IOException;
import java.util.*;

import static tasks.task6_23_11_2017.regexTask.entities.WordFrequencyHelper.getMapSortedByWordFrequency;
import static tasks.task6_23_11_2017.regexTask.entities.WordFrequencyHelper.iterateUrlsAndFillWordsFrequencies;

public class WordsFrequencyDemonstrator implements Demonstrator {

    private static final byte URL_NEEDED = 20;

    private String seekWord;
    private String initialUrl;
    private List<String> urls;
    Map<String, Map<String, Integer>> sortedByWord;

    public WordsFrequencyDemonstrator(List<String> urls, String seekWord) {
        this.urls = urls;
        this.seekWord = seekWord;
    }

    public WordsFrequencyDemonstrator(String initialUrl, String seekWord) throws IOException {
        this.initialUrl = initialUrl;
        this.seekWord = seekWord;
        initializeUrlList();
    }

    public List<String> getUrls() {
        return urls;
    }

    public String getInitialUrl() {
        return initialUrl;
    }

    public void setInitialUrl(String initialUrl) {
        this.initialUrl = initialUrl;
    }

    public String getSeekWord() {
        return seekWord;
    }

    public void setSeekWord(String seekWord) {
        this.seekWord = seekWord;
        this.sortedByWord = getMapSortedByWordFrequency(sortedByWord, seekWord);
    }

    public Map<String, Map<String, Integer>> getSortedByWord() {
        return sortedByWord;
    }

    public void demonstrate() {
        Map<String, Map<String, Integer>> urlWordsFrequencyMap = new HashMap<>();

        iterateUrlsAndFillWordsFrequencies(urls, urlWordsFrequencyMap, URL_NEEDED);

        System.out.println("\nSorting...\n");

        /*Получаем соритрованный по частоте слова map*/
        this.sortedByWord = getMapSortedByWordFrequency(urlWordsFrequencyMap, seekWord);

        printOuterMap();
    }

     void initializeUrlList() throws IOException {
        String text = new SiteInfoHelper(initialUrl).getSiteBodyText();
        String[] urlArr = SiteInfoHelper.getPageBodyUrls(text);

        urls = new ArrayList<>(Arrays.asList(urlArr));
    }

    public void printOuterMap(){
          /*Выводим сртированный map*/
        for (Map.Entry<String, Map<String, Integer>> entry : this.sortedByWord.entrySet()) {
            Integer count = entry.getValue().get(seekWord);
            System.out.println(entry.getKey() + ": " + entry.getValue());
            System.out.println(seekWord + " count: " + (count == null ? 0 : count));
        }
    }
}
