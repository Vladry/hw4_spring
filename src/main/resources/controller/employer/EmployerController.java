package com.homework3.controller.employer;

import com.homework3.DTO.EmployerRequestDto;
import com.homework3.DTO.EmployerResponseDto;
import com.homework3.domain.Employer;
import com.homework3.service.dtoMappers.EmployeeRequestDtoMapper;
import com.homework3.service.dtoMappers.EmployeeResponseDtoMapper;
import com.homework3.service.dtoMappers.EmployerArrayRequestMapper;
import com.homework3.service.EmployerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployerController {

    private final EmployerService service;
    private final EmployeeResponseDtoMapper respDtoMapper;
    private final EmployeeRequestDtoMapper reqDtoMapper;
    private final EmployerArrayRequestMapper arrayReqDtoMapper;

    EmployerController(EmployerService employerService,
                       EmployeeResponseDtoMapper employeeRespDtoMapper,
                       EmployeeRequestDtoMapper employeeReqDtoMapper,
                       EmployerArrayRequestMapper employerArrayReqDtoMapper) {
        this.service = employerService;
        this.respDtoMapper = employeeRespDtoMapper;
        this.reqDtoMapper = employeeReqDtoMapper;
        this.arrayReqDtoMapper = employerArrayReqDtoMapper;
    }


    /***  SAVING endpoints  ***/
    @PostMapping("/employers")
    public void saveEmployer(@RequestBody() EmployerRequestDto empReqDto) {
        Employer e = reqDtoMapper.convertToEntity(empReqDto);
        service.save(e);
    }

    @PostMapping("/employers/list")    //todo тут DTO mapping пока не реализую
    public void saveAllEmployers(@RequestBody List<EmployerRequestDto> le) {
        List<Employer> lemp = le.stream()
                .map(arrayReqDtoMapper::convertToEntity)
        .collect(Collectors.toList());
        service.saveAll(lemp);
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

    @DeleteMapping("/employers/list")   //todo тут DTO mapping пока не реализую
    public void deleteAllEmployers(@RequestBody List<Employer> le) {
        service.deleteAll(le);
    }

}
