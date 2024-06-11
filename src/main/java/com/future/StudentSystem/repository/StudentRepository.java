package com.future.StudentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.future.StudentSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
