package dao.interfaces;

import dao.interfaces.Dao;
import entities.Category;

import java.util.List;


public interface DaoCategory extends Dao<Category> {
    List<Category> findCategoriesAsc();
}
