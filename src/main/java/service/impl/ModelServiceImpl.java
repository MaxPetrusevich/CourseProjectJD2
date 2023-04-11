package service.impl;

import dao.impl.DaoModelImpl;
import dao.interfaces.DaoModel;
import dto.ModelDto;
import entities.Model;
import mapper.impl.ModelMapperImpl;
import mapper.interfaces.ModelMapper;
import service.interfaces.ModelService;

import java.util.List;
import java.util.stream.Collectors;

public class ModelServiceImpl implements ModelService {
    private static DaoModelImpl dao = new DaoModelImpl();
    private ModelMapper mapper = new ModelMapperImpl();
    @Override
    public ModelDto findById(Integer id){
        dao.getEm().clear();
        return mapper.entityToDto(dao.findById(id));
    }
    @Override
    public ModelDto save(ModelDto modelDto) {
        Model model = mapper.dtoToEntity(modelDto);
        dao.save(model);
        return modelDto;
    }

    @Override
    public void update(ModelDto modelDto) {
        dao.update(mapper.dtoToEntity(modelDto));
    }

    @Override
    public void delete(ModelDto modelDto) {
        dao.delete(mapper.dtoToEntity(modelDto));
    }

    @Override
    public List<ModelDto> findAll(ModelDto modelDto) {
        dao.getEm().clear();
        return dao.findAll(mapper.dtoToEntity(modelDto))
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
