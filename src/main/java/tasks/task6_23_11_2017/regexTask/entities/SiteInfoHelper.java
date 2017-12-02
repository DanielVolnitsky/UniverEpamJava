package tasks.task6_23_11_2017.regexTask.entities;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static String[] getPageBodyUrls(String bodyText) {
        Pattern urlPattern = Pattern.compile("(https?:\\/\\/)?([\\w\\.]+)\\.([a-z]{2,6}\\.?)(\\/[\\w\\-\\.]*)*\\/?");
        Matcher matcher = urlPattern.matcher(bodyText);

        StringBuilder builder = new StringBuilder();
        while (matcher.find())
            builder.append(matcher.group() + " ");

        return builder.toString().split("\\s");
    }
}
