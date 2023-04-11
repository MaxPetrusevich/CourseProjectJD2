package mapper.interfaces;

import dto.TypeDto;
import entities.Type;

public interface TypeMapper {
    Type dtoToEntity(TypeDto dto);
    TypeDto entityToDto(Type entity);
}
