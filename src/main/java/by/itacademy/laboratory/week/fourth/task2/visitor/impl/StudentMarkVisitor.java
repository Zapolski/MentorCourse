package by.itacademy.laboratory.week.fourth.task2.visitor.impl;

import by.itacademy.laboratory.week.fourth.task2.model.Student;
import by.itacademy.laboratory.week.fourth.task2.visitor.Visitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentMarkVisitor implements Visitor<Student> {

    private List<Integer> marks = new ArrayList<>();

    @Override
    public void visit(Student object) {
        marks.add(object.getMark());
    }

    public double averageStudentMark() {
        return marks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public int totalStudentMark() {
        return marks.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
