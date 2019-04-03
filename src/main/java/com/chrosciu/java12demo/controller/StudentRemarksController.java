package com.chrosciu.java12demo.controller;

import com.chrosciu.java12demo.dto.StudentRemarksDto;
import com.chrosciu.java12demo.service.RemarksPrettifierService;
import com.chrosciu.java12demo.service.StudentRemarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentRemarksController {
    private final StudentRemarksService studentRemarksService;
    private final RemarksPrettifierService remarksPrettifierService;

    @GetMapping(path="/students/{studentId}/remarks")
    public StudentRemarksDto getRemarks(@PathVariable("studentId") int studentId) {
        return studentRemarksService.getStudentRemarks(studentId);
    }

    @GetMapping(path="/students/{studentId}/remarks/pretty", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getRemarksPretty(@PathVariable("studentId") int studentId) {
        return remarksPrettifierService.prettifyRemarks(studentRemarksService.getStudentRemarks(studentId));
    }

}
