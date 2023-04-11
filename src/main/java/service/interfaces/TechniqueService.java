package service.interfaces;

import dto.TechniqueDto;
import entities.Category;
import entities.Model;
import entities.Store;

import java.sql.Types;
import java.util.List;
import java.util.Set;

public interface TechniqueService {
    TechniqueDto create(TechniqueDto techniqueDto);

    List<TechniqueDto> findLimit(int currentPage, int countRecords);

    void update(TechniqueDto techniqueDto);
    void delete(TechniqueDto techniqueDto);
   /* List<TechniqueDto> findLimitByCategory(int currentPage, int countRecords, String category);

    List<TechniqueDto> findLimitByTypes(int currentPage, int countRecords, String category, List<String> types);*/

    List<TechniqueDto> findLimitByPrice(int currentPage, int countRecords, int minPrice, int maxPrice);

    List<TechniqueDto> findByModel(/*int currentPage, int countRecords,*/ String model);

    List<TechniqueDto> findByProducer(/*int currentPage, int countRecords,*/ String producer);


    List<TechniqueDto> orderByPriceAsc();
     List<TechniqueDto> findByPrice(double minPrice, double maxPrice);
     TechniqueDto findById(Integer id);
    List<TechniqueDto> findAll();
}
