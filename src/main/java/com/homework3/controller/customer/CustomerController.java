package com.homework3.controller.customer;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.homework3.DTO.CustomerRequestDto;
import com.homework3.DTO.CustomerResponseDto;
import com.homework3.DTO.listCustomerDto;
import com.homework3.domain.Currency;
import com.homework3.domain.Customer;
import com.homework3.service.CustomerService;
import com.homework3.service.dtoMappers.CustomerRequestDtoMapper;
import com.homework3.service.dtoMappers.CustomerResponseDtoMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final CustomerService service;
    private final CustomerRequestDtoMapper custReqDtoMapper;
    private final CustomerResponseDtoMapper custRespDtoMapper;
    public CustomerController(CustomerService service,
                              CustomerRequestDtoMapper custReqDtoMapper,
                              CustomerResponseDtoMapper custRespDtoMapper) {
        this.service = service;
        this.custReqDtoMapper = custReqDtoMapper;
        this.custRespDtoMapper = custRespDtoMapper;
    }


    /*** ACCOUNT methods ***/
    @PostMapping("/customers/account")
    public Customer create(
            @RequestBody Currency currency, Long id){
        return service.createAccount(currency, id);
    }

    @PutMapping("/customers/account")
    public Customer delete(
            @RequestBody String accNumber, Long id){
        return service.deleteAccount(accNumber, id);
    }






    /*** RETRIEVE ***/
    @GetMapping("/customers/all")
    public List<Customer> findAll(){
        List<Customer> lc = service.findAll();
        System.out.println(lc);
        return lc;
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDto getById(@PathVariable("id") Long id){
        return custRespDtoMapper.convertToDto( service.getById(id) );
    }


    /*** CREATE ***/
    @PostMapping("/customers")
    public Customer save(
            @RequestBody Customer c) {
        service.save(c);
        return c;
    }

    @PutMapping("update/customers")
    public Customer update(
            @RequestBody Customer customer){
        return service.update(customer);
    }

    @PostMapping("/customers/all")
    public void saveAll(
           @Valid @RequestBody listCustomerDto lDto){
        List<CustomerRequestDto> lc = lDto.getList();
        service.saveAll( lc.stream().map(custReqDtoMapper::convertToEntity)
                .collect(Collectors.toList()) );
    }




    /*** DELETE ***/
    @DeleteMapping("/customers")
    public void delete(
            @RequestBody Customer c){
        service.delete(c);
    }

    @DeleteMapping("/customers/all")
    public void deleteAll(
            @RequestBody listCustomerDto lDto){
        List<CustomerRequestDto> lc = lDto.getList();
        service.deleteAll(lc.stream().map(custReqDtoMapper::convertToEntity)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/customers/{id}")
    public void deleteById( @PathVariable("id") Long id){
        service.deleteById(id);
    }



}
