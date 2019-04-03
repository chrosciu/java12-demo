package com.chrosciu.java12demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentRemarksDto {
    private String name;
    private List<String> remarks;
}
