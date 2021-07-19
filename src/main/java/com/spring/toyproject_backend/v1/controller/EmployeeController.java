package com.spring.toyproject_backend.v1.controller;

import com.spring.toyproject_backend.v1.exception.ResourceNotFoundException;
import com.spring.toyproject_backend.v1.model.EmployeeEntity;
import com.spring.toyproject_backend.v1.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    // dependency injection with constructor
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    // get list of all employees
    @GetMapping("/employeeList")
    public List<EmployeeEntity> getEmployeeList() {
        return employeeRepository.findAll();
    }

    // create
    @PostMapping("/createEmployee")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    // get one employee with id
    @GetMapping("employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not exist with id : " + id));

        return ResponseEntity.ok(employee);
    }

    // update
    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee){

        EmployeeEntity updatingEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee does not exist with id : " + id));

        updatingEmployee.setFirstName(employee.getFirstName());
        updatingEmployee.setLastName(employee.getLastName());
        updatingEmployee.setEmail(employee.getEmail());

        EmployeeEntity result = employeeRepository.save(updatingEmployee);
        return ResponseEntity.ok(result);
    }

    // delete
    @PostMapping("deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {

        // deleteById internally checks 'id-null case' with findById,
        // hence no need to process that logic. (Or, use findById + delete instead)
        employeeRepository.deleteById(id);
    }
}
