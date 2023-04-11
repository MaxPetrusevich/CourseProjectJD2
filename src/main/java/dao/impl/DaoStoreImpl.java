package dao.impl;

import dao.interfaces.DaoStore;
import entities.Store;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public class DaoStoreImpl extends DaoImpl<Store> implements DaoStore {
    private final EntityManager em = HibernateUtil.getEntityManager();

    public Store findById(Integer id){
        return em.find(Store.class, id);
    }
}
