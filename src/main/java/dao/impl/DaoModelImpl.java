package dao.impl;

import dao.interfaces.DaoModel;
import entities.Model;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public class DaoModelImpl extends DaoImpl<Model> implements DaoModel {
   private final EntityManager em = HibernateUtil.getEntityManager();

    public Model findById(Integer id){
        return em.find(Model.class, id);
    }
}
