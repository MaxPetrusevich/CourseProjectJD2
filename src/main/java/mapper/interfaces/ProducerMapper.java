package mapper.interfaces;

import dto.ProducerDto;
import entities.Producer;

public interface ProducerMapper {
    Producer dtoToEntity(ProducerDto dto);
    ProducerDto entityToDto(Producer entity);
}
