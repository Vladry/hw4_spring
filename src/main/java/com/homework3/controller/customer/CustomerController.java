package com.homework3.controller.customer;

import com.homework3.DTO.AccountRequestDto;
import com.homework3.DTO.CustomerRequestDto;
import com.homework3.DTO.CustomerResponseDto;
import com.homework3.DTO.listCustomerDto;
import com.homework3.domain.Account;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import com.homework3.service.AccountService;
import com.homework3.service.CustomerService;
import com.homework3.service.dtoMappers.CustomerRequestDtoMapper;
import com.homework3.service.dtoMappers.CustomerResponseDtoMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final AccountService accService;
    private final CustomerRequestDtoMapper custReqDtoMapper;
    private final CustomerResponseDtoMapper custRespDtoMapper;
    public CustomerController(CustomerService service,
                              AccountService accService,
                              CustomerRequestDtoMapper custReqDtoMapper,
                              CustomerResponseDtoMapper custRespDtoMapper) {
        this.customerService = service;
        this.accService = accService;
        this.custReqDtoMapper = custReqDtoMapper;
        this.custRespDtoMapper = custRespDtoMapper;
    }


    /*** ACCOUNT methods ***/
    @PostMapping("/customers/account")
    public CustomerResponseDto create(
            @RequestBody AccountRequestDto a){
        Currency[] cur = Currency.values();
        Customer c = customerService.getById(a.getId());
        Account ac = new Account(cur[a.getCurrency()], c);
        Account newAcc = accService.save(ac);
        c.getAccounts().add(newAcc);
        Customer returnCustomer =  customerService.update(c);
        CustomerResponseDto cDto = custRespDtoMapper.convertToDto(returnCustomer);
        custRespDtoMapper.decorateDto(cDto, returnCustomer);
        return cDto;
    }

    @DeleteMapping("/customers/account")
    public Customer delete(
            @RequestBody String accNumber, Long id){
        return customerService.deleteAccount(accNumber, id);
    }






    /*** RETRIEVE ***/
    @GetMapping("/customers/all")
    public List<Customer> findAll(){
        List<Customer> lc = customerService.findAll();
        System.out.println(lc);
        return lc;
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDto getById(@PathVariable("id") Long id){
        return custRespDtoMapper.convertToDto( customerService.getById(id) );
    }


    /*** CREATE ***/
    @PostMapping("/customers")
    public Customer save(
            @RequestBody Customer c) {
        customerService.save(c);
        return c;
    }

    @PutMapping("update/customers")
    public Customer update(
            @RequestBody Customer customer){
        return customerService.update(customer);
    }

    @PostMapping("/customers/all")
    public void saveAll(
           @Valid @RequestBody listCustomerDto lDto){
        List<CustomerRequestDto> lc = lDto.getList();
        customerService.saveAll( lc.stream().map(custReqDtoMapper::convertToEntity)
                .collect(Collectors.toList()) );
    }




    /*** DELETE ***/
    @DeleteMapping("/customers")
    public void delete(
            @RequestBody Customer c){
        customerService.delete(c);
    }

    @DeleteMapping("/customers/all")
    public void deleteAll(
            @RequestBody listCustomerDto lDto){
        List<CustomerRequestDto> lc = lDto.getList();
        customerService.deleteAll(lc.stream().map(custReqDtoMapper::convertToEntity)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/customers/{id}")
    public void deleteById( @PathVariable("id") Long id){
        customerService.deleteById(id);
    }



}
