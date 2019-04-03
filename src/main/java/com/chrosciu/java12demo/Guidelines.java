package com.chrosciu.java12demo;

import com.chrosciu.java12demo.model.Student;
import com.chrosciu.java12demo.service.StudentsService;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Guidelines {
    private StudentsService studentsService;

    public void variableNaming() {
        // ORIGINAL
        List<Student> list = studentsService.getStudents();

        // GOOD
        var students = studentsService.getStudents();

        // BAD, it's hard to think what does this variable really store
        //var list = studentsService.getStudents();
    }

    public void varIsRecommended() {
        // ORIGINAL
        Student student = new Student();

        // RECOMMENDED, to avoid redundancy
        //var student = new Student();
    }

    public void tooWideVariableScope() {
        var student = new Student();

        // a lot of code completely not connected with student

        student.setName("Jasiu");
    }

    void removeMatches(Map<? extends String, ? extends Number> map, int max) {
        for (Iterator<? extends Map.Entry<? extends String, ? extends Number>> iterator =
             map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<? extends String, ? extends Number> entry = iterator.next();
            if (max > 0 && matches(entry)) {
                iterator.remove();
                max--;
            }
        }
    }

    void removeMatchesWithoutNoise(Map<? extends String, ? extends Number> map, int max) {
        for (var iterator = map.entrySet().iterator(); iterator.hasNext();) {
            var entry = iterator.next();
            if (max > 0 && matches(entry)) {
                iterator.remove();
                max--;
            }
        }
    }

    private boolean matches(Map.Entry<? extends String, ? extends Number> entry) {
        //some logic
        return true;
    }
}
