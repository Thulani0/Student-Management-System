package com.future.StudentSystem.controller;

import com.future.StudentSystem.services.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.future.StudentSystem.model.Student;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class Studentcontroller {
    @Autowired
    private Studentservice studentservice;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentservice.saveStudent(student);
        return "New Student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }

    @DeleteMapping("/delStudent/{id}")
    public String delStudent(@PathVariable("id") int Id){
        studentservice.delStudent(Id);
        return "Student record deleted";
    }
}
