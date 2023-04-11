package service.impl;

import dao.impl.DaoStoreImpl;
import dao.interfaces.DaoStore;
import dto.StoreDto;
import mapper.impl.StoreMapperImpl;
import mapper.interfaces.StoreMapper;
import service.interfaces.StoreService;

import java.util.List;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {

    private static DaoStoreImpl dao = new DaoStoreImpl();
    private StoreMapper mapper = new StoreMapperImpl();
    @Override
    public StoreDto findById(Integer id){
        dao.getEm().clear();
        return  mapper.entityToDto(dao.findById(id));
    }

    @Override
    public StoreDto save(StoreDto storeDto) {
        dao.save(mapper.dtoToEntity(storeDto));
        return storeDto;
    }

    @Override
    public void update(StoreDto storeDto) {
        dao.update(mapper.dtoToEntity(storeDto));
    }

    @Override
    public void delete(StoreDto storeDto) {
        dao.delete(mapper.dtoToEntity(storeDto));
    }

    @Override
    public List<StoreDto> findAll(StoreDto storeDto) {
        dao.getEm().clear();
        return dao.findAll(mapper.dtoToEntity(storeDto))
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
