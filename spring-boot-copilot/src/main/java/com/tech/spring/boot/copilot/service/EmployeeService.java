package com.tech.spring.boot.copilot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.spring.boot.copilot.entity.Employee;
import com.tech.spring.boot.copilot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(String empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
		if (existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setSalary(employee.getSalary());
			existingEmployee.setDepartment(employee.getDepartment());
			return employeeRepository.save(existingEmployee);
		}
		return null;
	}

	public void deleteEmployee(String empId) {
		employeeRepository.deleteById(empId);
	}

}
