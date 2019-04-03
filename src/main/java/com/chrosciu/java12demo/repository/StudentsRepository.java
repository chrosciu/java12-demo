package com.chrosciu.java12demo.repository;

import com.chrosciu.java12demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
}
