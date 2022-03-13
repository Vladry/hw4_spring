package com.homework3.service;

import com.homework3.DTO.EmployerRequestDto;
import com.homework3.domain.Employer;
import org.springframework.stereotype.Service;


@Service
public class EmployeeRequestDtoMapper extends DtoMapperFacade<Employer, EmployerRequestDto>{

    public EmployeeRequestDtoMapper() {
        super(Employer.class, EmployerRequestDto.class);
    }

    @Override
    protected void decorateEntity(Employer entity, final EmployerRequestDto dto){}

    @Override
    protected void decorateDto(EmployerRequestDto dto, Employer entity){}
}
