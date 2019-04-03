package com.chrosciu.java12demo.repository;

import com.chrosciu.java12demo.model.StudentNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentNotesRepository extends JpaRepository<StudentNote, Integer> {
    List<StudentNote> findByStudentId(int studentId);
}
