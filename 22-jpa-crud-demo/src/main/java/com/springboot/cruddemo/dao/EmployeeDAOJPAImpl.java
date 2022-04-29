package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
    private EntityManager entityManager; // JPA

    @Autowired // optional
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create query JPA
        Query query = entityManager.createQuery("from Employee");

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = entityManager.find(Employee.class, id);
        // return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // save or update employee
        Employee employeedb = entityManager.merge(employee);

        // update with id from db so we cen get generated id
        employee.setId(employeedb.getId());
    }

    @Override
    public void deleteById(int id) {
// delete object with primary key
        Query query = entityManager.createQuery("delete from Employee where id=: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
