package com.homework2.DAO;

import com.homework2.domain.Account;
import com.homework2.domain.Currency;
import com.homework2.domain.Customer;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDao<T> extends abstractDao<Customer> {

    @PersistenceUnit
    EntityManagerFactory emf;

    public Customer update(Customer customer, Long id) {
        EntityManager em = emf.createEntityManager();
        Customer cust = em.find(Customer.class, id);
        if (cust != null) {
            em.getTransaction().begin();
            cust.setAccounts(customer.getAccounts());
            cust.setAge(cust.getAge());
            cust.setEmployers(customer.getEmployers());
            cust.setName(customer.getName());
            em.merge(cust);
            em.getTransaction().commit();
            em.close();
            return cust;
        } else {
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("DELETE FROM Customer c WHERE c IN (:customers)");
            q.setParameter("customers", entities);
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
        }
    }

    public Customer createAccount(Currency currency, Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer cust = em.find(Customer.class, id);
            if (cust != null) {
                em.getTransaction().begin();
                cust.getAccounts().add(new Account(currency, cust));
                em.merge(cust);
                em.getTransaction().commit();
                em.close();
                return cust;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public Customer deleteAccount(String accNumber, Long id) {
        EntityManager em = emf.createEntityManager();

        Customer cust = em.find(Customer.class, id);
        if (cust != null) {
            Account acc = null;
            for (Account account : cust.getAccounts()) {
                if (account.getNumber().equals(accNumber)) {
                    acc = account;
                    break;
                }
            }
            cust.getAccounts().remove(acc);
            em.getTransaction().begin();
//            em.flush();
            em.merge(cust);
            em.getTransaction().commit();
            em.close();
            return cust;
        }
        em.close();
        return null;
    }

    @Override
    public Customer save(Customer obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return obj;
    }

    @Override
    public void saveAll(List<Customer> entities) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entities);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Customer").getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    @Override
    public Customer getById(Long id) {
        EntityManager em = emf.createEntityManager();
        Customer cust = null;
        try {//        Customer cust = em.find(Customer.class, id);
            cust = (Customer) em.createQuery("SELECT c from Customer c WHERE c.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return cust;
    }


}
