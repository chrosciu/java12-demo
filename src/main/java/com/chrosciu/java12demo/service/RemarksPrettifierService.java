package com.chrosciu.java12demo.service;

import com.chrosciu.java12demo.dto.StudentRemarksDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RemarksPrettifierService {
    public String prettifyRemarks(StudentRemarksDto studentRemarksDto) {
        var name = studentRemarksDto.getName();
        var remarks = studentRemarksDto.getRemarks();
        var longestLineLength = findLongestLineLength(name, remarks);
        var border = "*".repeat(longestLineLength);
        var lineList = buildLineList(name, remarks, border);
        return String.join(System.lineSeparator(), lineList);
    }

    private int findLongestLineLength(String name, List<String> remarks) {
        var lines = new ArrayList<String>();
        lines.add(name);
        lines.addAll(remarks);
        return lines.stream().map(String::length).max(Integer::compareTo).orElseThrow();
    }

    private List<String> buildLineList(String name, List<String> remarks, String border) {
        var lines = new ArrayList<String>();
        lines.addAll(Arrays.asList(border, name, border));
        lines.addAll(remarks);
        lines.add(border);
        return lines;
    }
}
