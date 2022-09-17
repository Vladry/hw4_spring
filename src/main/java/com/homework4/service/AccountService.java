package com.homework4.service;

import com.homework4.DAO.AccountDao;
import com.homework4.repository.AccountJpaRepository;
import com.homework4.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountDao<Account> accountDao;
    AccountJpaRepository accountJpaRepository;

    public AccountService(AccountJpaRepository accountRepository){
        this.accountJpaRepository = accountRepository;
    }


/*** TRANSFER methods ***/
    public boolean putAmount(String accNum, Double amount) {
        return accountDao.putAmount(accNum, amount);
    }

    public boolean drawAmount(String accNum, Double amount) {
        return accountDao.drawAmount(accNum, amount);
    }

    public boolean transferAmount(String from, String to, Double amount) {
        boolean putSuccess = false;
        boolean drawSuccess = accountDao.drawAmount(from, amount);
        if (drawSuccess) {
            putSuccess = accountDao.putAmount(to, amount);
        } else {
            accountDao.putAmount(from, amount);
            return false;
        }
        if (putSuccess) {
            return true;
        } else {
            accountDao.putAmount(from, amount);
            return false;
        }
    }



    /*** BASIC methods ***/
    public Account save(Account a){
        accountJpaRepository.save(a);
        return a;
    }

    public void delete(Account a) {
        accountJpaRepository.delete(a);
    }

    public void deleteAll(List<Account> entities) {
        accountJpaRepository.deleteAll(entities);
    }

    public void saveAll(List<Account> entities) {
        System.out.println("in service.saveAll() ");
        accountJpaRepository.saveAll(entities);
    }

    public List<Account> findAll() {
        return accountJpaRepository.findAll();
    }

    public void deleteById(Long id){
        accountJpaRepository.deleteById(id);}

    public Optional<Account> getById(Long id) {
        return accountDao.getById(id);
    }

}
