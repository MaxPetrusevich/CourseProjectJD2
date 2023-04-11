package dao.impl;

import dao.interfaces.DaoCategory;
import dto.CategoryDto;
import entities.Category;
import entities.Technique;
import entities.Type;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class DaoCategoryImpl extends DaoImpl<Category> implements DaoCategory  {
    private EntityManager em = HibernateUtil.getEntityManager();


    public Category findById(Integer id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> criteria = cb.createQuery(Category.class);
        Root<Category> categoryRoot = criteria.from(Category.class);
        Join<Category, Type> join =  categoryRoot.join("types", JoinType.LEFT);
                criteria.select(categoryRoot).where(cb.equal(categoryRoot.get("id"), id));
        criteria.from(Category.class);
        Query query = em.createQuery(criteria);
        return (Category) query.getSingleResult();
    }
    @Override
    public List<Category> findCategoriesAsc() {
        CriteriaBuilder cb = super.getEm().getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        root.join("types", JoinType.LEFT);
        List<Category> categories = super.getEm().createQuery(query).getResultList();
        return categories;
    }
}
