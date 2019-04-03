package com.chrosciu.java12demo.controller;

import com.chrosciu.java12demo.dto.StudentNotesDto;
import com.chrosciu.java12demo.model.StudentNote;
import com.chrosciu.java12demo.service.StudentNotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequiredArgsConstructor
public class StudentNotesController {
    private final StudentNotesService studentNotesService;

    @GetMapping(path="/students/{studentId}/notes")
    public StudentNotesDto getNotes(@PathVariable("studentId") int studentId) {
        var notes = studentNotesService.getStudentNotes(studentId);
        notes.getNotes().removeIf(Predicate.not(StudentNote.isAcceptable));
        return notes;
    }

    @GetMapping(path="/students/{studentId}/notes/mostFrequent")
    public Optional<Integer> getMostFrequentNoteForStudent(@PathVariable("studentId") int studentId) {
        return studentNotesService.getMostFrequentNoteForStudent(studentId);
    }
}
