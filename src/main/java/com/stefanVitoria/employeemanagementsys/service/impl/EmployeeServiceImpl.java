package com.stefanVitoria.employeemanagementsys.service.impl;

import com.stefanVitoria.employeemanagementsys.model.Employee;
import com.stefanVitoria.employeemanagementsys.repository.EmployeeRepository;
import com.stefanVitoria.employeemanagementsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
