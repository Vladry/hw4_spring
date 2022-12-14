package vlad.homework4.service.dtoMappers;

import vlad.homework4.DTO.employer.EnlistedEmployerDto;
import vlad.homework4.domain.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerArrayRequestMapper extends DtoMapperFacade<Employer, EnlistedEmployerDto> {

    public EmployerArrayRequestMapper() {
        super(Employer.class, EnlistedEmployerDto.class);
    }

    @Override
    protected void decorateDto(final EnlistedEmployerDto dto, final Employer Employer){}
    @Override
    protected void decorateEntity(final Employer entity, final EnlistedEmployerDto dto){}
}
