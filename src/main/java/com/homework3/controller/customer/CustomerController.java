package com.homework3.controller.customer;

import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import com.homework3.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService service;
    public CustomerController(CustomerService service) {
        this.service = service;
    }

@PutMapping("update/customers")
    public Customer update(
            @RequestBody Customer customer){
        return service.update(customer);
    }

    @PostMapping("customers/account")
    public Customer create(
            @RequestBody Currency currency, Long id){
        return service.createAccount(currency, id);
    }

    @PutMapping("customers/account")

    public Customer delete(
            @RequestBody String accNumber, Long id){
        return service.deleteAccount(accNumber, id);
    }

    @DeleteMapping("/customers")
    public boolean delete(
            @RequestBody Customer c){
        return service.delete(c);
    }

    @DeleteMapping("/customers/all")
    public void deleteAll(
            @RequestBody List<Customer> lc){
        service.deleteAll(lc);
    }

    @PostMapping("/customers/all")
    public void saveAll(
            @RequestBody List<Customer> lc){
        System.out.println("in controller customers:  saveAll" + lc);
                service.saveAll(lc);
    }

//    @PostMapping("/customers/test")
//    public void saveAll(
//            @RequestBody List<Integer> lc){
//        System.out.println("in controller customers:  saveAll" + lc);
//    }

    @GetMapping("/customers/all")
    public List<Customer> findAll(){
        List<Customer> lc = service.findAll();
        System.out.println(lc);
        return lc;
    }

    @DeleteMapping("/customers/{id}")
    public boolean deleteById( @PathVariable("id") Long id){
        return service.deleteById(id);
    }

//
//    @GetMapping("/customers/{id}")
//    public Customer getById(@PathVariable("id") Long id){
//        return service.getById(id);
//    }


    @GetMapping("/customers/{id}")
    public Customer getById(@PathVariable("id") String id){
        return service.getById(Long.parseLong(id));
    }

    @PostMapping("/customers")
    public Customer save(
            @RequestBody Customer c) {
        service.save(c);
        return c;
    }

}
