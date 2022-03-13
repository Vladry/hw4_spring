package com.homework3.service.dtoMappers;

import com.homework3.DTO.EmployerArrDto;
import com.homework3.domain.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerArrayRequestMapper extends DtoMapperFacade<Employer, EmployerArrDto> {

    public EmployerArrayRequestMapper() {
        super(Employer.class, EmployerArrDto.class);
    }

    @Override
    protected void decorateDto(final EmployerArrDto dto, final Employer Employer){}
    @Override
    protected void decorateEntity(final Employer employer, final EmployerArrDto dto){}
}
