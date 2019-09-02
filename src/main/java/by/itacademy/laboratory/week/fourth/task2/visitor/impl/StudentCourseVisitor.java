package by.itacademy.laboratory.week.fourth.task2.visitor.impl;

import by.itacademy.laboratory.week.fourth.task2.model.Student;
import by.itacademy.laboratory.week.fourth.task2.visitor.Visitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentCourseVisitor implements Visitor<Student> {

    private List<Integer> courses = new ArrayList<>();

    @Override
    public void visit(Student object) {
       courses.add(object.getCourse());
    }

    public int minCourse() {
        return courses.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }

    public int maxCourse() {
        return courses.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}
