package com.msc.crudapidemo.dao;

import com.msc.crudapidemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
