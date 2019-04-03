package com.chrosciu.java12demo.service;

import com.chrosciu.java12demo.model.Student;
import com.chrosciu.java12demo.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {
    private final StudentsRepository studentsRepository;

    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }
}
