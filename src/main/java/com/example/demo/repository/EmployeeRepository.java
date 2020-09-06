package com.example.demo.repository;/*
 * @created 01/09/2020-1:56 PM
 * @project demo
 * @author Bibek Upreti
 */

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
