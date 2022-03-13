package com.homework3.service;

import com.homework3.DAO.EmployerDao;
import com.homework3.DAO.EmployerRepository;
import com.homework3.domain.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployerService {
    @Autowired
    EmployerDao<Employer> employerDao;

    @Autowired
    EmployerRepository JpaRepository;

    public Employer save(Employer obj) {
        employerDao.save(obj);
        return obj;
    }

    public boolean delete(Employer obj) {
        try {
            employerDao.delete(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteAll(List<Employer> entities) {
        employerDao.deleteAll(entities);
    }

    public void saveAll(List<Employer> entities) {
        employerDao.saveAll(entities);
    }
    public void saveAll_fromSet(Set<Employer> entities) {
        JpaRepository.saveAll(entities);
    }

    public List<Employer> findAll() {
        return employerDao.findAll();
    }

    public boolean deleteById(Long id) {
        try {
            employerDao.deleteById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Employer getById(Long id) {
        return employerDao.getById(id);
    }
}

