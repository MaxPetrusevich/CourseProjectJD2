package mapper.impl;

import dto.StoreDto;
import entities.Store;
import mapper.interfaces.StoreMapper;

public class StoreMapperImpl implements StoreMapper {
    @Override
    public Store dtoToEntity(StoreDto dto) {
        return Store.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .techniques(dto.getTechniques())
                .build();
    }

    @Override
    public StoreDto entityToDto(Store entity) {
        return StoreDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .techniques(entity.getTechniques())
                .build();
    }
}
