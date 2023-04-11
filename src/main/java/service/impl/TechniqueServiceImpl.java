package service.impl;

import dao.impl.DaoTechniqueImpl;
import dao.interfaces.Dao;
import dao.interfaces.DaoTechnique;
import dto.TechniqueDto;
import entities.Category;
import entities.Model;
import entities.Store;
import entities.Technique;
import lombok.Getter;
import mapper.impl.TechniqueMapperImpl;
import mapper.interfaces.TechniqueMapper;
import service.interfaces.TechniqueService;

import java.sql.Types;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class TechniqueServiceImpl implements TechniqueService {
    private static DaoTechniqueImpl dao = new DaoTechniqueImpl();
    private TechniqueMapper mapper = new TechniqueMapperImpl();

    @Override
    public TechniqueDto create(TechniqueDto techniqueDto) {
        Technique technique = mapper.dtoToEntity(techniqueDto);
        dao.save(technique);
        return techniqueDto;
    }

    @Override
    public List<TechniqueDto> findAll() {
        dao.getEm().clear();
        return dao.findAll(new Technique())
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TechniqueDto findById(Integer id) {
        dao.getEm().clear();
        Technique technique = Technique.builder().id(id).build();
        technique = dao.findById(id);
        return mapper.entityToDto(technique);
    }

    @Override
    public List<TechniqueDto> findLimit(int currentPage, int countRecords) {
        dao.getEm().clear();
        return dao.findLimit(currentPage, countRecords)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void update(TechniqueDto techniqueDto) {
        dao.update(mapper.dtoToEntity(techniqueDto));
    }

    @Override
    public void delete(TechniqueDto techniqueDto) {
        dao.delete(mapper.dtoToEntity(techniqueDto));
    }

  /*  @Override
    public List<TechniqueDto> findLimitByCategory(int currentPage, int countRecords, String category)
    {
        dao.getEm().clear();
        return dao.findLimitByCategory(currentPage, countRecords, category)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
*/
  /*  @Override
    public List<TechniqueDto> findLimitByTypes(int currentPage, int countRecords, String category, List<String> types) {
        dao.getEm().clear();
        return dao.findLimitByTypes(currentPage, countRecords, category, types)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }*/

    @Override
    public List<TechniqueDto> findLimitByPrice(int currentPage, int countRecords, int minPrice, int maxPrice) {
        dao.getEm().clear();
        return dao.findLimitByPrice(currentPage, countRecords, minPrice, maxPrice)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TechniqueDto> findByPrice(double minPrice, double maxPrice) {
        dao.getEm().clear();
        return dao.findByPrice(minPrice, maxPrice)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TechniqueDto> findByModel(/*int currentPage, int countRecords,*/ String model) {
        dao.getEm().clear();
        return dao.findByModel(/*currentPage, countRecords, */model)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TechniqueDto> findByProducer(/*int currentPage, int countRecords, */String producer) {
        dao.getEm().clear();
        return dao.findByProducer(/*currentPage, countRecords, */producer)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<TechniqueDto> orderByPriceAsc() {
        dao.getEm().clear();
        return dao.sortByPrice()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }


}
