package com.homework2.controller.account;

import com.homework2.DTO.AccountDto;
import com.homework2.domain.Account;
import com.homework2.domain.Customer;
import com.homework2.service.AccountService;
import com.homework2.service.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accService;
    private final CustomerService custService;
    public AccountController(AccountService accService, CustomerService custService) {
        this.accService = accService;
        this.custService = custService;
    }



    @PostMapping
    public Account save(
            @RequestBody AccountDto a) {
        Customer c = custService.getById(a.getCustomer_id());
        Account acc = new Account(a.getCurrency(), a.getBalance(), c);
        accService.save(acc);
        return acc;
    }


    @PostMapping("put-amount")
    public boolean putAmount(
            @RequestBody String accNum, Double amount) {
        return accService.putAmount(accNum, amount);
    }

    @PostMapping("draw-amount")
    public boolean drawAmount(
            @RequestBody String accNum, Double amount) {
        return accService.drawAmount(accNum, amount);
    }

    @PostMapping("make-transfer")
    public boolean transferAmount(
            @RequestBody String from, String to, Double amount) {
        return accService.transferAmount(from, to, amount);
    }

    @DeleteMapping
    public boolean delete(
            @RequestBody Account a) {
        return accService.delete(a);
    }

    @DeleteMapping("/all")
    public void deleteAll(
            @RequestBody List<Account> la) {
        accService.deleteAll(la);
    }

    @PostMapping("/all")
    public void saveAll(
            @RequestBody List<Account> la) {
        accService.saveAll(la);
    }

    @GetMapping("all")
    public List<Account> findAll() {
        return accService.findAll();
    }

    @DeleteMapping("{id}")
    public boolean deleteByIdL(@PathVariable("id") Long id) {
        return accService.deleteById(id);
    }

    @GetMapping("{id}")
    public Account getById(@PathVariable("id") Long id) {
        return accService.getById(id);
    }

}
