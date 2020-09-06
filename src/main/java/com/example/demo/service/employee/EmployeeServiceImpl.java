package com.example.demo.service.employee;/*
 * @created 01/09/2020-1:57 PM
 * @project demo
 * @author Bibek Upreti
 */

import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.address.AddressService;
import com.example.demo.validation.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private AddressService addressService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,AddressService addressService) {
        this.employeeRepository = employeeRepository;
        this.addressService = addressService;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeRepository.findById(id).orElseThrow(() -> (new RecordNotFoundException("User is not found")));
        }
        throw new RecordNotFoundException("user not found");
    }

    @Override
    public Employee addEmployee(Employee employee) {

//        User newUser=userService.addUser(student.getUser());
//        student.setUser(newUser);

        Address address=addressService.addAddress(employee.getAddress());
        employee.setAddress(address);


        return  employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployeeById(Long id) {
        Optional<Employee> employeeOption = employeeRepository.findById(id);
        if (employeeOption.isPresent()) {
            employeeRepository.deleteById(id);
        }
        throw new RecordNotFoundException("User is not found");
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Address address=addressService.updateAddress(employee.getId(),employee.getAddress());
        employee.setAddress(address);


        return employeeRepository.save(employee);


    }
}
