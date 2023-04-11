package dao.interfaces;


import entities.Technique;

import java.util.List;

public interface DaoTechnique extends Dao<Technique> {
     List<Technique> findLimit(int currentPage, int countRecords);

 /*    List<Technique> findLimitByCategory(int currentPage, int countRecords, String category);

     List<Technique> findLimitByTypes(int currentPage, int countRecords, String category, List<String> types);
*/
     List<Technique> findLimitByPrice(int currentPage, int countRecords, int minPrice, int maxPrice);

     List<Technique> findByModel(/*int currentPage, int countRecords, */String model);

     List<Technique> findByProducer(/*int currentPage, int countRecords,*/ String producer);



}
