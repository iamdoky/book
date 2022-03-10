package server.api.book.practice.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupComponentBook {
    public static void getBooksCategory() {

        final String url = "https://www.aladin.co.kr/home/wbookmain.aspx";
        Connection conn = Jsoup.connect(url);

        try {
            Document document = conn.get();
            String categoryList = getCategoryList(document);
            System.out.println(categoryList);

        } catch (IOException e) {

        }
    }

    public static String getCategoryList(Document document) {
        Elements stockTableBody = document.select("div.eb_category_menu ul li").not(".browseLayer").not(".browse_sub");
        StringBuilder sb = new StringBuilder();
        for ( Element element : stockTableBody ) {
            String categoryTitle = element.text();
            String categoryId = element.select("a").get(0).attr("href").split("=")[1].toString();
            System.out.println(categoryTitle + " : " + categoryId);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        getBooksCategory();
    }
}
