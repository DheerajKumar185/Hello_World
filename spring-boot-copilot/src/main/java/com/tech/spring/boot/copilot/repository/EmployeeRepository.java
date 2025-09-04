package com.tech.spring.boot.copilot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tech.spring.boot.copilot.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
