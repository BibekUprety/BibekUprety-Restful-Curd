package com.example.demo.service.employee;/*
 * @created 01/09/2020-1:57 PM
 * @project demo
 * @author Bibek Upreti
 */

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
