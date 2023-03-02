package com.stefanVitoria.employeemanagementsys.repository;

import com.stefanVitoria.employeemanagementsys.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
