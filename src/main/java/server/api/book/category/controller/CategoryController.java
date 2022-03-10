package server.api.book.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.api.book.category.domain.CategoryDto;
import server.api.book.category.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category/list")
    public List<CategoryDto> getCategoryList(HttpServletRequest request ) {
        return categoryService.getCategoryList();
    }

}
