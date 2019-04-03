package com.chrosciu.java12demo.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    public List<String> readLines(@NonNull String path) {
        try {
            return Files.readString(Paths.get(getClass().getResource(path).toURI())).lines().collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
