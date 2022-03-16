package com.homework3.service.dtoMappers;

import com.homework3.DTO.CustomerResponseDto;
import com.homework3.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerResponseDtoMapper extends DtoMapperFacade<Customer, CustomerResponseDto> {

    public CustomerResponseDtoMapper() {
        super(Customer.class, CustomerResponseDto.class);
    }

    @Override
    protected void decorateDto(final CustomerResponseDto dto, final Customer entity) {
    }

    @Override
    protected void decorateEntity(final Customer entity, final CustomerResponseDto dto){
        List<String> accNumberList = entity.getAccounts().stream().map(a-> a.getCurrency().toString()).collect(Collectors.toList());
        String accNumberString = accNumberList.toString();
        dto.setAccounts_currency(accNumberString);
    }

}
