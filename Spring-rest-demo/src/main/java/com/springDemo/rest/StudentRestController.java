package com.springDemo.rest;

import com.springDemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    // define @PostConstruct to load student data only once
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Jonas", "Jonaitis"));
        students.add(new Student("Petras", "Petraitis"));
        students.add(new Student("Maryte", "Marityte"));
    }

    // define endpoint for "/students" - return list of Students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // just index into the list, keep it simple for now
        // check student id against list size
        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("student id not found : " + studentId);
        }
        return students.get(studentId);
    }



}
