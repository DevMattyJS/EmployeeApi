package com.msc.crudapidemo.dao;

import com.msc.crudapidemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    // We don't use @Transactional here, because it's a good practice to apply transactional boundaries at the service layer
    // It is a service layer's responsibility to manage transactional boundaries
    @Override
    public Employee save(Employee employee) {

        // entityManager.merge() => insert or update the employee based on id
        // if id == 0 => insert a new entry into db, otherwise update the existing entry
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = findById(id);
        entityManager.remove(employee);
    }
}
