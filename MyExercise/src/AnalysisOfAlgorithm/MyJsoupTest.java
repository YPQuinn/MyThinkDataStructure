package AnalysisOfAlgorithm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author quinn
 * @create 2021-03-12 10:46
 */
public class MyJsoupTest {
    public static void main(String[] args) throws IOException {
        String url = "https://en.wanweibaike.com/wiki-Java%20Programming";
        long start = System.currentTimeMillis();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Time is:" + (System.currentTimeMillis() - start) + "ms");
        }
        Elements elem = doc.getElementsByTag("Title");
        System.out.println("Title is:" + elem.text());
    }
}
