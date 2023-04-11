package mapper.impl;

import dto.ModelDto;
import entities.Model;
import mapper.interfaces.ModelMapper;

public class ModelMapperImpl implements ModelMapper {
    @Override
    public Model dtoToEntity(ModelDto dto) {
        return Model.builder()
                .id(dto.getId())
                .name(dto.getName())
                .techniques(dto.getTechniques())
                .build();
    }

    @Override
    public ModelDto entityToDto(Model entity) {
        return ModelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .techniques(entity.getTechniques())
                .build();
    }
}
