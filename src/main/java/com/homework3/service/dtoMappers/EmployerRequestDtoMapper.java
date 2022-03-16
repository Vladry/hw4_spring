package com.homework3.service.dtoMappers;

import com.homework3.DTO.employer.EmployerRequestDto;
import com.homework3.domain.Employer;
import org.springframework.stereotype.Service;


@Service
public class EmployerRequestDtoMapper extends DtoMapperFacade<Employer, EmployerRequestDto>{

    public EmployerRequestDtoMapper() {
        super(Employer.class, EmployerRequestDto.class);
    }

    @Override
    protected void decorateEntity(Employer entity, final EmployerRequestDto dto){}

    @Override
    protected void decorateDto(EmployerRequestDto dto, Employer entity){}
}
