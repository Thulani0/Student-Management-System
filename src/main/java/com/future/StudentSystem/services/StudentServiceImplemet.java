package com.future.StudentSystem.services;

import com.future.StudentSystem.model.Student;
import com.future.StudentSystem.repository.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplemet  implements Studentservice{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void delStudent(int id) {
        studentRepository.deleteById(id);
    }
}