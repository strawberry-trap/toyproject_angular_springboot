package com.spring.toyproject_backend.v1.controller;

import com.spring.toyproject_backend.v1.exception.ResourceNotFoundException;
import com.spring.toyproject_backend.v1.model.UserEntity;
import com.spring.toyproject_backend.v1.repository.UserRepository;
import com.spring.toyproject_backend.v1.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    // dependency injection with constructor
    public UserController(UserService userService){
        this.userService = userService;
    }

    // get all
    @GetMapping("/userList")
    public ResponseEntity<List<UserEntity>> getUserList() {

        List<UserEntity> users = userService.getUserList();
        if (users.size() == 0) {
            return ResponseEntity.noContent().build(); // no data from server
        }
        return ResponseEntity.ok(users);
    }

    // get one
    @GetMapping("employee/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {

        Optional<UserEntity> user = userService.getUserById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.noContent().build();
    }

    // create
    @PostMapping("/createUser")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {

        Optional<UserEntity> createdUser = userService.createUser(user);

        if( createdUser.isPresent() ){
            return ResponseEntity.ok(createdUser.get());
        }
        return ResponseEntity.internalServerError().build();
    }

    // update
    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user){

        UserEntity updatedUser = userService.updateUser(id, user);
        if (updatedUser.getId() == -1) { // not updated
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    // delete
    @PostMapping("deleteUser/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {

        userService.deleteUser(id);
        Optional<UserEntity> shouldNotExist= userService.getUserById(id);
        if (shouldNotExist.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        else return ResponseEntity.ok().build();
    }
}

//
//
//@RestController
//@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
//public class EmployeeController {
//
//    private EmployeeServiceImpl employeeService;
//
//    // dependency injection with constructor
//    public EmployeeController(EmployeeServiceImpl employeeService){
//        this.employeeService = employeeService;
//    }
//
//    // get list of all employees
//    @GetMapping("/employeeList")
//    public List<EmployeeEntity> getEmployeeList() {
//
//        return employeeService.getEmployeeList();
//    }
//
//    // create
//    @PostMapping("/createEmployee")
//    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
//        return employeeService.createEmployee(employee);
//    }
//
//    // get one employee with id
//    @GetMapping("employee/{id}")
//    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
//
//        return ResponseEntity.ok(employeeService.getEmployeeById(id));
//    }
//
//    // update
//    @PutMapping("updateEmployee/{id}")
//    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee){
//
//        EmployeeEntity updatingEmployee = employeeService.updateEmployee(id, employee);
//        return ResponseEntity.ok(updatingEmployee);
//    }
//
//    // delete
//    @PostMapping("deleteEmployee/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//
//        // deleteById internally checks 'id-null case' with findById,
//        // hence no need to process that logic. (Or, use findById + delete instead)
//        employeeService.deleteEmployee(id);
//    }
//}
