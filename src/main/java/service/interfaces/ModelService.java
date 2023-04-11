package service.interfaces;

import dto.ModelDto;

import java.util.List;

public interface ModelService {
    ModelDto findById(Integer id);
    ModelDto save(ModelDto modelDto);

    void update(ModelDto modelDto);

    void delete(ModelDto modelDto);

    List<ModelDto> findAll(ModelDto modelDto);
}
