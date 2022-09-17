package com.homework4.service;

import com.homework4.repository.EmployerJpaRepository;
import com.homework4.domain.Employer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployerService {

    //    private final EmployerDao<Employer> employerDao;
    private final EmployerJpaRepository JpaRepository;

    public EmployerService(/*EmployerDao<Employer> employerDao,*/
            EmployerJpaRepository JpaRepository) {
//        this.employerDao = employerDao;
        this.JpaRepository = JpaRepository;
    }

    public Employer save(Employer obj) {
        JpaRepository.save(obj);
        return obj;
    }

    public boolean delete(Employer obj) {
        try {
            JpaRepository.delete(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteAll(List<Employer> entities) {
        JpaRepository.deleteAll(entities);
    }

    public void saveAll(List<Employer> entities) {
        JpaRepository.saveAll(entities);
    }

    public void saveAll_fromSet(Set<Employer> entities) {
        JpaRepository.saveAll(entities);
    }

    public List<Employer> findAll() {
        return JpaRepository.findAll();
    }

    public boolean deleteById(Long id) {
        try {
            JpaRepository.deleteById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Employer getById(Long id) {
        return JpaRepository.getById(id);
    }

    public void deleteAllEmployersFromDB() {
        JpaRepository.deleteAll();
    }
}

