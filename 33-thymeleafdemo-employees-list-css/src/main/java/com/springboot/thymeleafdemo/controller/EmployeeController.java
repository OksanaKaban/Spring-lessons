package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    // load employee data
    private List<Employee> employeeList;

    @PostConstruct
    private void loadData() {
        // create employees
        Employee employee = new Employee(1, "Jurgis", "Jurgutis", "jurgis@one.lt");
        Employee employee1 = new Employee(2, "Petras", "Petriukas", "petras@one.lt");
        Employee employee2 = new Employee(3, "Inga", "Ingute", "inga@one.lt");

        // create list
        employeeList = new ArrayList<>();

        // add to list
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
    }
    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        // add spring model
        model.addAttribute("employees", employeeList);
        return "list-employees";
    }


}
