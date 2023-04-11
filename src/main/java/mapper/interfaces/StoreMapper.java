package mapper.interfaces;

import dto.StoreDto;
import entities.Store;

public interface StoreMapper {
    Store dtoToEntity(StoreDto dto);
    StoreDto entityToDto(Store entity);
}
