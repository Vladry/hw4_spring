package com.homework3.service.dtoMappers;

import com.homework3.DTO.EmployerResponseDto;
import com.homework3.domain.Employer;
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
