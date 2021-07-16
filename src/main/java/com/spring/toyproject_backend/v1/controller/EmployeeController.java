package com.spring.toyproject_backend.v1.controller;

import com.spring.toyproject_backend.v1.model.EmployeeEntity;
import com.spring.toyproject_backend.v1.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    // dependency injection with constructor
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employeeList")
    public List<EmployeeEntity> getEmployeeList() {
        return employeeRepository.findAll();
    }
}
