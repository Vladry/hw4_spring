package com.homework3.service.dtoMappers;

import com.homework3.DTO.CustomerRequestDto;
import com.homework3.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerRequestDtoMapper extends DtoMapperFacade<Customer, CustomerRequestDto> {

    public CustomerRequestDtoMapper() {
        super(Customer.class, CustomerRequestDto.class);
    }

    @Override
    protected void decorateDto(final CustomerRequestDto dto, final Customer entity) {
    }

    ;

}
