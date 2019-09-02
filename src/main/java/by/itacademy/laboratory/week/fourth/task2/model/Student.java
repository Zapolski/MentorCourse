package by.itacademy.laboratory.week.fourth.task2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Integer mark;
    private Integer course;
}
