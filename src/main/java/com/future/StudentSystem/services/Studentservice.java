package com.future.StudentSystem.services;

import com.future.StudentSystem.model.Student;

import java.util.List;


public interface Studentservice {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public void delStudent(int id);
}
