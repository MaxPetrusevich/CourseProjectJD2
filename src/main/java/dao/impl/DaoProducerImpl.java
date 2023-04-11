package dao.impl;

import dao.interfaces.DaoProducer;
import entities.Producer;
import util.HibernateUtil;

import javax.persistence.EntityManager;

public class DaoProducerImpl extends DaoImpl<Producer> implements DaoProducer {
    private final EntityManager em = HibernateUtil.getEntityManager();

    public Producer findById(Integer id) {
        return em.find(Producer.class, id);
    }
}
