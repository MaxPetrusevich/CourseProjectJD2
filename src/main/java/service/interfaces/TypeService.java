package service.interfaces;

import dto.TypeDto;
import entities.Type;

import java.util.List;

public interface TypeService {
    TypeDto save(TypeDto typeDto);

    void update(TypeDto typeDto);

    void delete(TypeDto typeDto);

    TypeDto findById(Integer id);

    List<TypeDto> findAll(TypeDto typeDto);
}
