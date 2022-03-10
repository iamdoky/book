package server.api.book.category.component;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import server.api.book.category.domain.CategoryDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryComponent {

    public List<CategoryDto> getCategoryList() {
        final String url = "https://www.aladin.co.kr/home/wbookmain.aspx";
        Connection conn = Jsoup.connect(url);

        try {
            Document document = conn.get();
            return getCategoryList(document);
        } catch (IOException ignored) {

        }
        return null;
    }

    public List<CategoryDto> getCategoryList(Document document) {
        Elements categoryDiv = document.select("div.eb_category_menu ul li").not(".browseLayer").not(".browse_sub");
        List<CategoryDto> list = new ArrayList<>();
        for (Element element : categoryDiv) {

            CategoryDto categoryDto = CategoryDto.builder().build();
            categoryDto.setCategoryId(element.text());
            categoryDto.setCategoryTitle(element.select("a").get(0).attr("href").split("=")[1]);

            list.add(categoryDto);
        }
        return list;
    }
}
