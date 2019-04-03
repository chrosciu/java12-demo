package com.chrosciu.java12demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentNotesDto {
    private String name;
    private List<Integer> notes;
}
