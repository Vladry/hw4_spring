package vlad.homework4.controller.employer;

import vlad.homework4.DTO.employer.listEmployerDto;
import vlad.homework4.DTO.employer.EmployerRequestDto;
import vlad.homework4.DTO.employer.EmployerResponseDto;
import vlad.homework4.domain.Employer;
import vlad.homework4.service.dtoMappers.EmployerRequestDtoMapper;
import vlad.homework4.service.dtoMappers.EmployeeResponseDtoMapper;
import vlad.homework4.service.EmployerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class EmployerController {

    private final EmployerService service;
    private final EmployeeResponseDtoMapper respDtoMapper;
    private final EmployerRequestDtoMapper reqDtoMapper;

    EmployerController(EmployerService employerService,
                       EmployeeResponseDtoMapper employeeRespDtoMapper,
                       EmployerRequestDtoMapper employeeReqDtoMapper) {
        this.service = employerService;
        this.respDtoMapper = employeeRespDtoMapper;
        this.reqDtoMapper = employeeReqDtoMapper;
    }


    /***  SAVING endpoints  ***/
    @PostMapping("/employers")
    public void saveEmployer(@Valid @RequestBody() EmployerRequestDto empReqDto) {
        Employer e = reqDtoMapper.convertToEntity(empReqDto);
        service.save(e);
    }


    @PostMapping("/employers/list")
    public void saveAllEmployers(@Valid @RequestBody listEmployerDto lDto) {
        List<EmployerRequestDto> lEmp = lDto.getList();
        Set<Employer> le = lEmp.stream().map(reqDtoMapper::convertToEntity)
                .collect(Collectors.toSet());
        service.saveAll_fromSet(le);
    }


    /*** RETRIEVE endpoints ***/
    @GetMapping("/employers/all")
    public List<EmployerResponseDto> findAll() {
        return service.findAll().stream().map(respDtoMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/employers/{id}")
    public EmployerResponseDto getEmployerById(@PathVariable("id") Long id) {
        Employer e = service.getById(id);
        return respDtoMapper.convertToDto(e);
    }


    /***  DELETE endpoints  ***/
    @DeleteMapping("/employers")   //todo тут DTO mapping пока не реализую
    public void deleteEmployer(@RequestBody Employer e) {
        service.delete(e);
    }

    @DeleteMapping("/employers/{id}")
    public void deleteEmployerById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/employers/list")
    public void deleteAllEmployers(@RequestBody listEmployerDto lDto) {
        List<EmployerRequestDto> le = lDto.getList();
        service.deleteAll( le.stream().map(reqDtoMapper::convertToEntity).collect(Collectors.toList()) );
    }

    @DeleteMapping("/employers/all")
    public void deleteAllEmployersFromDB() {
        service.deleteAllEmployersFromDB();
    }
}
