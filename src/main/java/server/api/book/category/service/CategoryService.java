package server.api.book.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.book.category.component.CategoryComponent;
import server.api.book.category.domain.CategoryDto;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryComponent categoryComponent;

    public List<CategoryDto> getCategoryList() {
        return categoryComponent.getCategoryList();
    }


}
