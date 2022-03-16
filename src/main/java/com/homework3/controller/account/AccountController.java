package com.homework3.controller.account;

import com.homework3.DTO.AccountRequestDto;
import com.homework3.DTO.Account_Id_Dto;
import com.homework3.domain.Account;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import com.homework3.service.AccountService;
import com.homework3.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accService;
    private final CustomerService customerService;
    public AccountController(AccountService accService, CustomerService customerService) {
        this.accService = accService;
        this.customerService = customerService;
    }


    /*** ACCOUNT methods ***/
    @PostMapping
    public Account create(
            @RequestBody AccountRequestDto a){
        Currency[] cur = Currency.values();
        Customer c;
        Account ac = null;
        try {
            c = customerService.getById(a.getId());
            ac = new Account(cur[a.getCurrency()], a.getBalance(), c);
            accService.save(ac);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such customer in database!");
        }
        return ac;
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id){
        accService.deleteById(id);
    }





//    @PostMapping
//    public Account save(
//            @RequestBody Account_Id_Dto a) {
//        Customer c = customerService.getById(a.getCustomer_id());
//        Account acc = new Account(a.getCurrency(), a.getBalance(), c);
//        accService.save(acc);
//        return acc;
//    }
//

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

//    @DeleteMapping
//    public boolean delete(
//            @RequestBody Account a) {
//        return accService.delete(a);
//    }

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

//    @DeleteMapping("{id}")
//    public void deleteByIdL(@PathVariable("id") Long id) {
//        accService.deleteById(id);
//    }

    @GetMapping("{id}")
    public Account getById(@PathVariable("id") Long id) {
        return accService.getById(id);
    }

}
