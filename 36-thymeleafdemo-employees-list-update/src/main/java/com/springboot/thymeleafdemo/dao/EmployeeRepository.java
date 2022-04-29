package com.springboot.thymeleafdemo.dao;


import com.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it. no need to write any code

    // add method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

}
