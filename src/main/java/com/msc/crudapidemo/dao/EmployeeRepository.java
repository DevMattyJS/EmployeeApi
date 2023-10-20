package com.msc.crudapidemo.dao;

import com.msc.crudapidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Using Spring Data JPA
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // CRUD methods created behind the scenes => no more code needed here
    // also no need for implementation class
}
