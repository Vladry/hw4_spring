package com.homework3.controller.customer;

import com.fasterxml.jackson.annotation.JsonView;
import com.homework3.DTO.Views;
import com.homework3.DTO.customer.CustomerRequestDto;
import com.homework3.DTO.customer.CustomerResponseDto;
import com.homework3.DTO.customer.listCustomerDto;
import com.homework3.domain.Customer;
import com.homework3.service.CustomerService;
import com.homework3.service.dtoMappers.CustomerRequestDtoMapper;
import com.homework3.service.dtoMappers.CustomerResponseDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRequestDtoMapper custReqDtoMapper;
    private final CustomerResponseDtoMapper custRespDtoMapper;

    public CustomerController(CustomerService service,
                              CustomerRequestDtoMapper custReqDtoMapper,
                              CustomerResponseDtoMapper custRespDtoMapper) {
        this.customerService = service;
        this.custReqDtoMapper = custReqDtoMapper;
        this.custRespDtoMapper = custRespDtoMapper;
    }


    /*** RETRIEVE ***/

    @GetMapping("/customers/all-paged")
    public List<CustomerResponseDto> getAllPaged(
            @RequestParam("pagenumber") int pageNumber,
            @RequestParam("pagesize") int pageSize
    ) {
        Page<Customer> custPage = customerService.getPagedAll(pageNumber, pageSize);
        List<CustomerResponseDto> crDto = custPage.stream().map(custRespDtoMapper::convertToDto)
                .collect(Collectors.toList());
        return crDto;
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/customers/all")
    public List<Customer> findAll() {
        List<Customer> lc = customerService.findAll();
        System.out.println(lc);
        return lc;
    }

    @JsonView(Views.Public.class)
    @GetMapping("/customers/{id}")
    public CustomerResponseDto getById(@PathVariable("id") Long id) {
        return custRespDtoMapper.convertToDto(customerService.getById(id));
    }


    /*** CREATE ***/
    @PostMapping("/customers")
    public Customer save(
            @Valid @RequestBody CustomerRequestDto c) {
        Customer cEntity = custReqDtoMapper.convertToEntity(c);
        customerService.save(cEntity);
        return cEntity;
    }

    @PutMapping("update/customers")
    public Customer update(
            @RequestBody CustomerRequestDto c) {
        Customer cEntity = custReqDtoMapper.convertToEntity(c);
        customerService.save(cEntity);
        return cEntity;
    }


    @PostMapping("/customers/all")
    public void saveAll(
            @Valid @RequestBody listCustomerDto<CustomerRequestDto> lDto) {
        List<CustomerRequestDto> lc = lDto.getList();
        customerService.saveAll(lc.stream().map(custReqDtoMapper::convertToEntity)
                .collect(Collectors.toList()));
    }


    /*** DELETE ***/
    @DeleteMapping("/customers")
    public void delete(
            @RequestBody Customer c) {
        customerService.delete(c);
    }

    @DeleteMapping("/customers/all")
    public void deleteAll(
            @RequestBody listCustomerDto lDto) {
        List<CustomerRequestDto> lc = lDto.getList();
        customerService.deleteAll(lc.stream().map(custReqDtoMapper::convertToEntity)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/customers/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

}
