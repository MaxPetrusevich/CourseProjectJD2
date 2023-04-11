package mapper.interfaces;

import dto.CategoryDto;
import entities.Category;

public interface CategoryMapper {
    Category dtoToEntity(CategoryDto dto);
    CategoryDto entityToDto(Category entity);
}
