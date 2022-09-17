package com.homework4.service.dtoMappers;

import com.homework4.DTO.employer.EmployerResponseDto;
import com.homework4.domain.Employer;
import org.springframework.stereotype.Service;


@Service
public class EmployeeResponseDtoMapper extends DtoMapperFacade<Employer, EmployerResponseDto>{

    public EmployeeResponseDtoMapper() {
        super(Employer.class, EmployerResponseDto.class);
    }

    @Override
    protected void decorateEntity(final Employer entity, final EmployerResponseDto dto){}

    @Override
    protected void decorateDto(final EmployerResponseDto dto, final Employer entity){}
}
