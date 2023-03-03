package com.stefanVitoria.employeemanagementsys.service.impl;

import com.stefanVitoria.employeemanagementsys.exception.ResourceNotFoundException;
import com.stefanVitoria.employeemanagementsys.model.Employee;
import com.stefanVitoria.employeemanagementsys.repository.EmployeeRepository;
import com.stefanVitoria.employeemanagementsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
//        return employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee", "Id", id));

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee employeeToUpdate = this.getEmployeeById(id);
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmail(employee.getEmail());
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Void deleteEmployee(Long id) {
        Employee employeeToDelete = this.getEmployeeById(id);
        employeeRepository.delete(employeeToDelete);
        return null;
    }


}
