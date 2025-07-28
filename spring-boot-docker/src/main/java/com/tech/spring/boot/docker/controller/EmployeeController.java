package com.tech.spring.boot.docker.controller;

import com.tech.spring.boot.docker.dto.Employee;
import com.tech.spring.boot.docker.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newRecord = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> list = employeeService.getEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        Employee updatedRecord = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") int id) {
        String status = employeeService.removeEmployee(id);
        return new ResponseEntity<>(status, HttpStatus.NO_CONTENT);
    }
}
