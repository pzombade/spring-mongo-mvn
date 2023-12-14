package com.spring.mongo.springmongo.controllers;

import com.spring.mongo.springmongo.models.Employee;
import com.spring.mongo.springmongo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return  employeeRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public Long deleteEmployee(@PathVariable Long id){
          employeeRepository.deleteById(id);
          return  id;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return  employeeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody Employee employee){
        System.out.println("Saving employee");
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }
}
