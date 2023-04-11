package dao.impl;

import dao.interfaces.DaoType;
import entities.Type;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public class DaoTypeImpl extends DaoImpl<Type> implements DaoType {
    private EntityManager em = HibernateUtil.getEntityManager();

    public Type findById(Integer id){
        return em.find(Type.class, id);
    }
}
