package by.zapolski.week04.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private final String name;
    private String course;
    private float avgGrade;

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
