package dao.impl;

import dao.interfaces.Dao;
import lombok.Getter;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;
@Getter
public class DaoImpl<T> implements Dao<T> {
    private EntityManager em = HibernateUtil.getEntityManager();
    @Override
    public T save(T object) {
        em.clear();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        return object;
    }

    @Override
    public void update(T object) {
        em.clear();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();

    }

    @Override
    public T findById(T object) {
        em.clear();
        return (T) em.find(object.getClass(), object);
    }

    @Override
    public void delete(T object) {
        em.clear();
        em.getTransaction().begin();
        em.remove(em.contains(object) ? object : em.merge(object));
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll(T object) {
        em.clear();
        String sql = "from " + object.getClass().getSimpleName();
        return em.createQuery(sql).getResultList();
    }
}
