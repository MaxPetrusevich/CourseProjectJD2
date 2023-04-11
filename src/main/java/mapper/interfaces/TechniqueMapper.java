package mapper.interfaces;

import dto.TechniqueDto;
import entities.Technique;

public interface TechniqueMapper{
    Technique dtoToEntity(TechniqueDto dto);
    TechniqueDto entityToDto(Technique entity);
}
