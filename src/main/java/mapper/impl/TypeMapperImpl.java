package mapper.impl;

import dto.TypeDto;
import entities.Type;
import mapper.interfaces.CategoryMapper;
import mapper.interfaces.TypeMapper;

public class TypeMapperImpl implements TypeMapper {
    private CategoryMapper mapper = new CategoryMapperImpl();
    @Override
    public Type dtoToEntity(TypeDto dto) {
        return Type.builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .build();
    }

    @Override
    public TypeDto entityToDto(Type entity) {
        return TypeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .build();
    }
}
