package mapper.interfaces;

import dto.ModelDto;
import entities.Model;

public interface ModelMapper {
    Model dtoToEntity(ModelDto dto);

    ModelDto entityToDto(Model entity);
}
