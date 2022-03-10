package com.homework2.service;

import com.homework2.DAO.AccountDao;
import com.homework2.DAO.CustomerDao;
import com.homework2.domain.Account;
import com.homework2.domain.Currency;
import com.homework2.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerDao<Customer> customerDao;
    private final AccountDao<Account> accountDao;

    public CustomerService(CustomerDao<Customer> customerDao, AccountDao<Account> accountDao) {
        this.customerDao = customerDao;
        this.accountDao = accountDao;
    }

    public Customer update(Customer customer, Long id) {
        return customerDao.update(customer, id);
    }

    public void save(Customer c) {
        customerDao.save(c);
    }

    public Customer createAccount(Currency currency, Long id) {
        return customerDao.createAccount(currency, id);
    }

    public Customer deleteAccount(String accNumber, Long id) {
        return customerDao.deleteAccount(accNumber, id);
    }

    public boolean delete(Customer c) {
        return customerDao.delete(c);
    }

    public void deleteAll(List<Customer> entities) {
        customerDao.deleteAll(entities);
    }

    public void saveAll(List<Customer> entities) {
        customerDao.saveAll(entities);
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public boolean deleteById(Long id) {
        return customerDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Customer getById(Long id) {
        return customerDao.getById(id);
    }
}
