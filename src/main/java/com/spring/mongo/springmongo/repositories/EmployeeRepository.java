package com.spring.mongo.springmongo.repositories;

import com.spring.mongo.springmongo.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    public Optional<Employee> findById(Long id);
}
