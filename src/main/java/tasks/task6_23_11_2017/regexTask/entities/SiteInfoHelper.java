package tasks.task6_23_11_2017.regexTask.entities;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class SiteInfoHelper {

    public static String getSiteBodyText(String url) throws IOException {
        try {
            Connection connection = Jsoup.connect(url);
            Document doc = connection.get();
            return doc.body().text();
        } catch (IllegalArgumentException e) {
            throw new IOException("invalid url");
        }
    }
}
