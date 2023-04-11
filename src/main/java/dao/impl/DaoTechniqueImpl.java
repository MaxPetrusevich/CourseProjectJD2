package dao.impl;

import dao.interfaces.DaoTechnique;
import dto.TechniqueDto;
import entities.*;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTechniqueImpl extends DaoImpl<Technique> implements DaoTechnique {
    private  EntityManager em = HibernateUtil.getEntityManager();
    private CriteriaBuilder cb = em.getCriteriaBuilder();
    @Override
    public Technique save(Technique technique) {
        em.getTransaction().begin();
        em.persist(technique);
        em.getTransaction().commit();
        return technique;
    }

    public Technique findById(Integer id) {
        return em.find(Technique.class, id);
    }



    public List<Technique> findAll() {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category").join("types");
        techniqueRoot.join("model");
        techniqueRoot.join("producer");
        techniqueRoot.join("storeList");
        criteria.from(Technique.class);
        Query query = em.createQuery(criteria);
        return query.getResultList();
    }
    public List<Technique> sortByPrice() {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category",JoinType.LEFT).join("types", JoinType.LEFT);
        techniqueRoot.join("model", JoinType.LEFT);
        techniqueRoot.join("producer", JoinType.LEFT);
        techniqueRoot.join("storeList", JoinType.LEFT);
        criteria.orderBy(cb.asc(techniqueRoot.get("price")));
/*
        criteria.where(cb.between(techniqueRoot.get("price"), minPrice, maxPrice));
*/
        criteria.select(techniqueRoot);
        //  criteria.from(Technique.class);

        Query query = em.createQuery(criteria);
        List<Technique> techniques = query.getResultList();
        return techniques;
    }
    @Override
    public List<Technique> findLimit(int currentPage, int countRecords) {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category").join("types");
        techniqueRoot.join("model");
        techniqueRoot.join("producer");
        techniqueRoot.join("storeList");
        criteria.select(techniqueRoot);
        criteria.from(Technique.class);
        TypedQuery<Technique> typedQuery = em.createQuery(criteria);
        typedQuery.setFirstResult(countRecords * (currentPage - 1));
        typedQuery.setMaxResults(countRecords);
        List<Technique> techniques = typedQuery.getResultList();
        return techniques;
    }

    public List<Technique> findByPrice(double minPrice, double maxPrice) {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category",JoinType.LEFT).join("types", JoinType.LEFT);
        techniqueRoot.join("model", JoinType.LEFT);
        techniqueRoot.join("producer", JoinType.LEFT);
        techniqueRoot.join("storeList", JoinType.LEFT);
        criteria.orderBy(cb.asc(techniqueRoot.get("price")));
/*
        criteria.where(cb.between(techniqueRoot.get("price"), minPrice, maxPrice));
*/
        criteria.select(techniqueRoot);
      //  criteria.from(Technique.class);

        Query query = em.createQuery(criteria);
        List<Technique> techniques = query.getResultList();
        List<Technique> resultList = new ArrayList<>();
        for (Technique technique:
             techniques) {
            if(!(technique.getPrice() < minPrice) && !(technique.getPrice() > maxPrice) && !technique.getPrice().isNaN()){
                resultList.add(technique);
            }
        }
        return resultList;
    }

    @Override
    public List<Technique> findLimitByPrice(int currentPage, int countRecords, int minPrice, int maxPrice) {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category").join("types");
        techniqueRoot.join("model");
        techniqueRoot.join("producer");
        techniqueRoot.join("storeList");
        criteria.from(Technique.class);
        criteria.where(cb.between(techniqueRoot.get("price"), minPrice, maxPrice));
        TypedQuery<Technique> typedQuery = em.createQuery(criteria);
        typedQuery.setFirstResult(countRecords * (currentPage - 1));
        typedQuery.setMaxResults(countRecords);
        List<Technique> techniques = typedQuery.getResultList();
        return techniques;
    }

    @Override
    public List<Technique> findByModel(/*int currentPage, int countRecords,*/ String model) {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category",JoinType.LEFT).join("types",JoinType.LEFT);
        techniqueRoot.join("model",JoinType.LEFT);
        techniqueRoot.join("producer",JoinType.LEFT);
        techniqueRoot.join("storeList",JoinType.LEFT);
        criteria.where(cb.like(techniqueRoot.get("model").get("name"), "%"+model+"%"));
     //   criteria.from(Technique.class);
        criteria.select(techniqueRoot);
       /* TypedQuery<Technique> typedQuery = em.createQuery(criteria);
        typedQuery.setFirstResult(countRecords * (currentPage - 1));
        typedQuery.setMaxResults(countRecords);
        List<Technique> techniques = typedQuery.getResultList();*/
        List<Technique> techniques = em.createQuery(criteria).getResultList();
        return techniques;
    }

    @Override
    public List<Technique> findByProducer(/*int currentPage, int countRecords, */String producer) {
        CriteriaQuery<Technique> criteria = cb.createQuery(Technique.class);
        Root<Technique> techniqueRoot = criteria.from(Technique.class);
        techniqueRoot.join("category", JoinType.LEFT).join("types", JoinType.LEFT);
        techniqueRoot.join("model", JoinType.LEFT);
        techniqueRoot.join("producer", JoinType.LEFT);
        techniqueRoot.join("storeList", JoinType.LEFT);
        criteria.where(cb.like(techniqueRoot.get("producer").get("name"), "%"+producer+"%"));
     //   criteria.from(Technique.class);
        criteria.select(techniqueRoot);
      /*  TypedQuery<Technique> typedQuery = em.createQuery(criteria);
        typedQuery.setFirstResult(countRecords * (currentPage - 1));
        typedQuery.setMaxResults(countRecords);
        List<Technique> techniques = typedQuery.getResultList();*/
        List<Technique> techniques = em.createQuery(criteria).getResultList();
        return techniques;
    }




}
