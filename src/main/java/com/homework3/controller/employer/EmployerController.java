package com.homework3.controller.employer;

import com.homework3.DTO.EmployerRequestDto;
import com.homework3.DTO.EmployerResponseDto;
import com.homework3.domain.Employer;
import com.homework3.service.EmployeeRequestDtoMapper;
import com.homework3.service.EmployeeResponseDtoMapper;
import com.homework3.service.EmployerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployerController {

    private final EmployerService service;
    private final EmployeeResponseDtoMapper respDtoMapper;
    private final EmployeeRequestDtoMapper reqDtoMapper;

    EmployerController(EmployerService employerService,
                       EmployeeResponseDtoMapper employeeRespDtoMapper,
                       EmployeeRequestDtoMapper employeeReqDtoMapper) {
        this.service = employerService;
        this.respDtoMapper = employeeRespDtoMapper;
        this.reqDtoMapper = employeeReqDtoMapper;
    }


    /***  SAVING endpoints  ***/
    @PostMapping("/employer")
    public void saveEmployer(@RequestBody() EmployerRequestDto empReqDto) {
        Employer e = reqDtoMapper.convertToEntity(empReqDto);
        service.save(e);
    }

    @PostMapping("/employers")    //todo тут DTO mapping пока не реализую
    public void saveAllEmployers(@RequestBody List<Employer> le) {
        service.saveAll(le);
    }

    @GetMapping("/employers")    //todo тут DTO mapping пока не реализую
    public List<Employer> findAll() {
        return service.findAll();
    }



    @PostMapping("/employer/{id}")
    public void getEmployerById(@PathVariable("id") Long id) {
        service.getById(id);
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
