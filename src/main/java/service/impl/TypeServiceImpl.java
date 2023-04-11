package service.impl;

import dao.impl.DaoTypeImpl;
import dao.interfaces.DaoType;
import dto.TypeDto;
import entities.Type;
import mapper.impl.TypeMapperImpl;
import mapper.interfaces.TypeMapper;
import service.interfaces.TypeService;

import java.util.List;
import java.util.stream.Collectors;

public class TypeServiceImpl implements TypeService {
    private static DaoTypeImpl dao = new DaoTypeImpl();
    private TypeMapper mapper = new TypeMapperImpl();
    @Override
    public TypeDto save(TypeDto typeDto) {
        dao.save(mapper.dtoToEntity(typeDto));
        return typeDto;
    }

    @Override
    public void update(TypeDto typeDto) {
        dao.update(mapper.dtoToEntity(typeDto));
    }

    @Override
    public void delete(TypeDto typeDto) {
        dao.delete(mapper.dtoToEntity(typeDto));
    }

    @Override
    public TypeDto findById(Integer id) {
        dao.getEm().clear();
        return mapper.entityToDto(dao.findById(id));
    }

    @Override
    public List<TypeDto> findAll(TypeDto typeDto) {
        dao.getEm().clear();
        return dao.findAll(mapper.dtoToEntity(typeDto))
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
