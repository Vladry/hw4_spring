package com.homework3.DAO;

import com.homework3.domain.Employer;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class EmployerDao<T> implements Dao<Employer> {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Override
    public Employer save(Employer obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            em.close();
            return obj;
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean delete(Employer obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
        return false;
    }

    @Override
    public void deleteAll(List<Employer> entities) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("DELETE FROM Employer e WHERE e IN (:emp)")
                    .setParameter("emp", entities);
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void saveAll(List<Employer> entities) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entities);
        em.getTransaction().commit();
        em.close();
    }

    public void saveAll_fromSet(Set<Employer> entities) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entities);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Employer> findAll() {
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT e FROM Employer e");
        List<Employer> el = q.getResultList();
        em.close();
        return el;
    }

    @Override
    public boolean deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        Employer e = em.find(Employer.class, id);
        try {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
            em.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return false;
        }
        return true;
    }

    @Override
    public Employer getById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Employer.class, id);
    }
}
