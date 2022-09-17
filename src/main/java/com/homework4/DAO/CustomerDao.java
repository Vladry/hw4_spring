package com.homework4.DAO;

import com.homework4.domain.Account;
import com.homework4.domain.Currency;
import com.homework4.domain.Customer;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
public class CustomerDao<T> {

    @PersistenceUnit
    EntityManagerFactory emf;

//    public Customer update(Customer customer) {
//        EntityManager em = emf.createEntityManager();
//        Customer cust = em.find(Customer.class, customer.getId());
//        if (cust != null) {
//            em.getTransaction().begin();
//            cust.setAccounts(customer.getAccounts());
//            cust.setAge(cust.getAge());
//            cust.setEmployers(customer.getEmployers());
//            cust.setName(customer.getName());
//            em.merge(cust);
//            em.getTransaction().commit();
//            em.close();
//            return cust;
//        } else {
//            em.getTransaction().rollback();
//            em.close();
//            return null;
//        }
//    }

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

}
