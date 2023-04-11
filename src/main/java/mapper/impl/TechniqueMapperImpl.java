package mapper.impl;

import dto.StoreDto;
import dto.TechniqueDto;
import entities.Store;
import entities.Technique;
import mapper.interfaces.StoreMapper;
import mapper.interfaces.TechniqueMapper;

import java.util.Set;
import java.util.stream.Collectors;

public class TechniqueMapperImpl implements TechniqueMapper {
    private StoreMapper mapper = new StoreMapperImpl();
    @Override
    public Technique dtoToEntity(TechniqueDto dto) {
        return Technique.builder()
                .id(dto.getId())
                .price(dto.getPrice())
                .model(dto.getModel())
                .producer(dto.getProducer())
                .storeList(dto.getStoreList())
                .category(dto.getCategory())
                .build();
    }

    @Override
    public TechniqueDto entityToDto(Technique entity) {
        return TechniqueDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .storeList(entity.getStoreList())
                .category(entity.getCategory())
                .model(entity.getModel())
                .producer(entity.getProducer())
                .build();
    }
}
