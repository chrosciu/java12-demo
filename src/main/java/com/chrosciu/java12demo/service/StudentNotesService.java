package com.chrosciu.java12demo.service;

import com.chrosciu.java12demo.dto.StudentNotesDto;
import com.chrosciu.java12demo.model.Student;
import com.chrosciu.java12demo.model.StudentNote;
import com.chrosciu.java12demo.repository.StudentNotesRepository;
import com.chrosciu.java12demo.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class StudentNotesService {
    private final StudentNotesRepository studentNotesRepository;
    private final StudentsRepository studentsRepository;

    public StudentNotesDto getStudentNotes(int studentId) {
        var studentName = studentsRepository.findById(studentId).map(Student::getName).orElseThrow();
        var studentNotes = studentNotesRepository.findByStudentId(studentId);
        var notes = studentNotes.stream()
                .map(StudentNote::getNote)
                .collect(Collectors.toList());
                //.collect(Collectors.toUnmodifiableList());
        return buildDto(studentName, notes);
    }

    private StudentNotesDto buildDto(String name, List<Integer> notes) {
        var studentNotesDto = new StudentNotesDto();
        studentNotesDto.setName(name);
        studentNotesDto.setNotes(notes);
        return studentNotesDto;
    };

    public Optional<Integer> getMostFrequentNoteForStudent(int studentId) {
        var studentNotes = studentNotesRepository.findByStudentId(studentId);
        var notesFrequencyMap = studentNotes.stream().collect(groupingBy(StudentNote::getNote, counting()));
        var mostFrequentNoteEntry = notesFrequencyMap.entrySet().stream().max(Map.Entry.comparingByValue());
        return mostFrequentNoteEntry.map(Map.Entry::getKey);
    }

}
