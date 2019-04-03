package com.chrosciu.java12demo.controller;

import com.chrosciu.java12demo.model.Student;
import com.chrosciu.java12demo.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;

    @GetMapping(path="/students")
    public List<Student> getStudents() {
        return studentsService.getStudents();
    }
}
