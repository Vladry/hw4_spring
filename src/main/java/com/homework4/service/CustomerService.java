package com.homework4.service;

import com.homework4.DAO.CustomerDao;
import com.homework4.repository.CustomerJpaRepository;
import com.homework4.domain.Currency;
import com.homework4.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//@Slf4j
public class CustomerService {

    private final CustomerDao<Customer> customerDao;
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerService(CustomerDao<Customer> customerDao, CustomerJpaRepository customerJpaRepository) {
        this.customerDao = customerDao;
        this.customerJpaRepository = customerJpaRepository;
    }


    public Page<Customer> getPagedAll(int pageNumber, int pageSize){
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return customerJpaRepository.findAll(pageable);
    };

    public Customer update(Customer customer) {
        return customerJpaRepository.save(customer);
    }

    public void save(Customer c) {
        customerJpaRepository.save(c);
    }

    public Customer createAccount(Currency currency, Long id) {
        return customerDao.createAccount(currency, id);
    }

    public Customer deleteAccount(String accNumber, Long id) {
        return customerDao.deleteAccount(accNumber, id);
    }

    public void delete(Customer c) {
        customerJpaRepository.delete(c);
    }

    public void deleteAll(List<Customer> entities) {
        customerJpaRepository.deleteAll(entities);
    }

    public void saveAll(List<Customer> entities) {
        customerJpaRepository.saveAll(entities);
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerJpaRepository.findAll();
    }

    public void deleteById(Long id) {
        customerJpaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Customer getById(Long id) {
        return customerJpaRepository.getById(id);
    }
}
