package com.chrosciu.java12demo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.function.Predicate;

@Entity(name = "STUDENT_NOTES")
@Getter
@Setter
public class StudentNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId;
    private Integer note;

    public static Predicate<Integer> isAcceptable = (@NonNull var note) -> switch (note) {
        case 1, 2 -> false;
        default -> true;
    };
}
