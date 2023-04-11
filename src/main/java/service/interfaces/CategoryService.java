package service.interfaces;

import dto.CategoryDto;
import entities.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(Integer id);
    CategoryDto save(CategoryDto categoryDto);

    void update(CategoryDto categoryDto);

    void delete(CategoryDto categoryDto);

    List<CategoryDto> findAll(CategoryDto categoryDto);
}
