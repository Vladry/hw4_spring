package com.homework3.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

public abstract class abstractDao<T> implements Dao<T> {

    @PersistenceUnit
    EntityManagerFactory emf;


    @Override
    public T save(T obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        return obj;
    }

    @Override
    public boolean delete(T obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.close();
            }
            return false;
        }
        return true;
    }

    @Override
    public void deleteAll(List<T> entities) {
    }

    @Override
    public void saveAll(List<T> entities) {
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
            return false;
    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
