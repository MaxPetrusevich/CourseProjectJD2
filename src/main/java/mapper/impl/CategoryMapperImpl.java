package mapper.impl;

import dto.CategoryDto;
import dto.TypeDto;
import entities.Category;
import entities.Type;
import mapper.interfaces.CategoryMapper;
import mapper.interfaces.TypeMapper;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryMapperImpl implements CategoryMapper {
    private static TypeMapper mapper = new TypeMapperImpl();

    @Override
    public Category dtoToEntity(CategoryDto dto) {
        return Category.builder()
                .name(dto.getName())
                .id(dto.getId())
                .techniques(dto.getTechniques())
                .types(dto.getTypes())
                .build();
    }

    @Override
    public CategoryDto entityToDto(Category entity) {
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .types(entity.getTypes())
                .techniques(entity.getTechniques())
                .build();
    }
}
