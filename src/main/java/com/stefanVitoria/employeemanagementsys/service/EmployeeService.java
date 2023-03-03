package com.stefanVitoria.employeemanagementsys.service;

import com.stefanVitoria.employeemanagementsys.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee, Long id);
    Void deleteEmployee(Long id);

}
