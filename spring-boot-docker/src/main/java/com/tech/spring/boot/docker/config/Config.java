package com.tech.spring.boot.docker.config;

import com.tech.spring.boot.docker.dto.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    private final List<Employee> list = new ArrayList<>();
    @PostConstruct
    public void initEmployee() {
        list.add(new Employee(101, "Alice Johnson", 85000, "Software Development"));
        list.add(new Employee(102, "Bob Smith", 92000, "Cyber Security"));
        list.add(new Employee(103, "Charlie Brown", 78000, "Cloud Computing"));
        list.add(new Employee(104, "David Williams", 97000, "Artificial Intelligence"));
        list.add(new Employee(105, "Emma Watson", 89000, "Software Development"));
        list.add(new Employee(106, "Frank Miller", 76000, "Data Science"));
        list.add(new Employee(107, "Grace Lee", 94000, "DevOps"));
        list.add(new Employee(108, "Henry Clark", 81000, "IT Support"));
        list.add(new Employee(109, "Ivy Adams", 88000, "Networking"));
        list.add(new Employee(110, "Jack Davis", 93000, "Database Administration"));
    }

    @Bean
    public List<Employee> getEmployees() {
        return list;
    }

}
