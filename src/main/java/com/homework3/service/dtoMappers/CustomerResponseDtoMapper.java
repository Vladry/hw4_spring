package com.homework3.service.dtoMappers;

import com.homework3.DTO.CustomerRequestDto;
import com.homework3.DTO.CustomerResponseDto;
import com.homework3.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerResponseDtoMapper extends DtoMapperFacade<Customer, CustomerResponseDto> {

    public CustomerResponseDtoMapper() {
        super(Customer.class, CustomerResponseDto.class);
    }

    @Override
    protected void decorateDto(final CustomerResponseDto dto, final Customer entity) {
    }

    ;

}
