package mapper.impl;

import dto.ProducerDto;
import entities.Producer;
import mapper.interfaces.ProducerMapper;

public class ProducerMapperImpl implements ProducerMapper {
    @Override
    public Producer dtoToEntity(ProducerDto dto) {
        return Producer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(dto.getCountry())
                .techniques(dto.getTechniques())
                .build();
    }

    @Override
    public ProducerDto entityToDto(Producer entity) {
        return ProducerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(entity.getCountry())
                .techniques(entity.getTechniques())
                .build();
    }
}
