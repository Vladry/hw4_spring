package com.homework4.service.dtoMappers;

import com.homework4.DTO.employer.listEmployerDto;
import com.homework4.domain.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerArrayRequestMapper extends DtoMapperFacade<Employer, listEmployerDto> {

    public EmployerArrayRequestMapper() {
        super(Employer.class, listEmployerDto.class);
    }

    @Override
    protected void decorateDto(final listEmployerDto dto, final Employer Employer){}
    @Override
    protected void decorateEntity(final Employer entity, final listEmployerDto dto){}
}
