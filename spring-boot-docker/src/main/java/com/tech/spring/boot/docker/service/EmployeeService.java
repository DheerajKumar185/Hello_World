package com.tech.spring.boot.docker.service;

import com.tech.spring.boot.docker.constant.Constants;
import com.tech.spring.boot.docker.dto.Employee;
import com.tech.spring.boot.docker.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> list;

    @Autowired
    public EmployeeService(List<Employee> list) {
        this.list = list;
    }

    public Employee addEmployee(Employee employee) {
        int id = list.size();
        employee.setId(list.get(id-1).getId() + 1);
        list.add(employee);
        return employee;
    }

    public List<Employee> getEmployee() {
        return list;
    }

    public Employee findById(int id) {
        return list.stream().filter(emp -> emp.getId()==id)
                .findAny().orElseThrow(() -> new RecordNotFoundException(String.format(Constants.EMPLOYEE_MESSAGE, id)));
    }

    public Employee updateEmployee(Employee employee, int id) {
        Employee updatedRecord = list.stream().filter(emp -> emp.getId()==id)
                .findAny().orElseThrow(() -> new RecordNotFoundException(String.format(Constants.EMPLOYEE_MESSAGE, id)));
        updatedRecord.setName(employee.getName());
        updatedRecord.setSalary(employee.getSalary());
        updatedRecord.setDepartment(employee.getDepartment());
        return updatedRecord;
    }

    public String removeEmployee(int id) {
        Employee deletedRecord = list.stream().filter(emp -> emp.getId()==id)
                .findAny().orElseThrow(() -> new RecordNotFoundException(String.format(Constants.EMPLOYEE_MESSAGE, id)));
        list.remove(deletedRecord);
        return "deleted";
    }
}
