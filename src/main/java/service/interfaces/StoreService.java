package service.interfaces;

import dto.StoreDto;

import java.util.List;

public interface StoreService {
    StoreDto findById(Integer id);
    StoreDto save(StoreDto storeDto);

    void update(StoreDto storeDto);

    void delete(StoreDto storeDto);

    List<StoreDto> findAll(StoreDto storeDto);
}
