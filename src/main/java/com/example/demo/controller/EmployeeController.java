package com.example.demo.controller;/*
 * @created 01/09/2020-8:07 PM
 * @project demo
 * @author Bibek Upreti
 */

import com.example.demo.model.Employee;
import com.example.demo.service.employee.EmployeeService;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ResponseBody
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ResponseBody
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    @ResponseBody
    public Employee getEmployeeId(@PathVariable("id")Long id){
        return employeeService.getEmployeeById(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        employeeService.deleteEmployeeById(id);
    }

    @ResponseBody
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  updateEmployee(Long id,@RequestBody Employee employee){
        employeeService.updateEmployee(id,employee);
    }
}
