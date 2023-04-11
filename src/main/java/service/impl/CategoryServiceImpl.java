package service.impl;

import dao.impl.DaoCategoryImpl;
import dao.impl.DaoTypeImpl;
import dao.interfaces.DaoCategory;
import dao.interfaces.DaoType;
import dto.CategoryDto;
import entities.Category;
import entities.Technique;
import entities.Type;
import mapper.impl.CategoryMapperImpl;
import mapper.interfaces.CategoryMapper;
import service.interfaces.CategoryService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private static DaoCategoryImpl dao = new DaoCategoryImpl();
    private CategoryMapper mapper = new CategoryMapperImpl();

    @Override
    public CategoryDto findById(Integer id) {
        dao.getEm().clear();
        return mapper.entityToDto(dao.findById(id));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = mapper.dtoToEntity(categoryDto);
        dao.save(category);
        return categoryDto;
    }

    @Override
    public void update(CategoryDto categoryDto) {
        Category category = mapper.dtoToEntity(categoryDto);
        DaoType typeDao = new DaoTypeImpl();
        List<Type> oldTypes = typeDao.findAll(new Type());
        for (Type type :
                oldTypes) {
            type.setCategory(null);
            typeDao.update(type);
        }
        for (Type type :
                category.getTypes()) {
            type.setCategory(category);
            typeDao.update(type);
        }
        dao.update(category);
    }

    @Override
    public void delete(CategoryDto categoryDto) {
        dao.delete(mapper.dtoToEntity(categoryDto));
    }

    @Override
    public List<CategoryDto> findAll(CategoryDto categoryDto) {
        dao.getEm().clear();
        return dao.findAll(mapper.dtoToEntity(categoryDto))
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
