package com.chrosciu.java12demo.service;

import com.chrosciu.java12demo.dto.StudentRemarksDto;
import com.chrosciu.java12demo.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentRemarksService {
    private final StudentsRepository studentsRepository;
    private final FileService fileService;

    public StudentRemarksDto getStudentRemarks(int studentId) {
        var student = studentsRepository.findById(studentId).orElseThrow();
        var remarks = fileService.readLines(String.format("/remarks%d.txt", studentId));
        var notBlankRemarks = remarks.stream()
                .map(String::strip)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        StudentRemarksDto StudentRemarksDto = new StudentRemarksDto();
        StudentRemarksDto.setName(student.getName());
        StudentRemarksDto.setRemarks(notBlankRemarks);
        return StudentRemarksDto;
    }
}
