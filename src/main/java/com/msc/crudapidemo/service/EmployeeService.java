package com.msc.crudapidemo.service;

import com.msc.crudapidemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
