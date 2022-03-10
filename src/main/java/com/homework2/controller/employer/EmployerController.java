package com.homework2.controller.employer;

import com.homework2.domain.Employer;
import com.homework2.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployerController {

    @Autowired
    EmployerService service;

    @PostMapping("/employer")
    public void saveEmployer(@RequestBody() Employer e) {
        service.save(e);
    }

    @DeleteMapping("/employer")
    public void deleteEmployer(@RequestBody Employer e) {
        service.delete(e);
    }

    @DeleteMapping("/employers")
    public void deleteAllEmployers(@RequestBody List<Employer> le) {
        service.deleteAll(le);
    }

    @PostMapping("/employers")
    public void saveAllEmployers(@RequestBody List<Employer> le) {
        service.saveAll(le);
    }

    @GetMapping("/employers")
    public List<Employer> findAll() {
        return service.findAll();
    }

    @GetMapping("/employer/{id}")
    public void deleteEmployerById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PostMapping("/employer/{id}")
    public void getEmployerById(@PathVariable("id") Long id) {
        service.getById(id);
    }

}
