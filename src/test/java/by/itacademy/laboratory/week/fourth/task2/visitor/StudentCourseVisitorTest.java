package by.itacademy.laboratory.week.fourth.task2.visitor;

import by.itacademy.laboratory.week.fourth.task1.domain.TreeSearchStrategy;
import by.itacademy.laboratory.week.fourth.task1.iterator.TreeIterator;
import by.itacademy.laboratory.week.fourth.task2.model.Student;
import by.itacademy.laboratory.week.fourth.task2.model.TreeVisitNode;
import by.itacademy.laboratory.week.fourth.task2.visitor.impl.StudentCourseVisitor;
import by.itacademy.laboratory.week.fourth.util.TreeNodeEntityUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentCourseVisitorTest {

    @Test
    public void checkStudentCourseVisitor() {
        TreeVisitNode<Student> root = TreeNodeEntityUtil.buildStudentVistiTree();
        TreeIterator<Student, TreeVisitNode<Student>> iterator = new TreeIterator<>(root, TreeSearchStrategy.DFS_PRE_ORDER);
        StudentCourseVisitor visitor = new StudentCourseVisitor();
        TreeVisitTraversal.traverseTree(iterator, visitor);

        int actualMinCourse = visitor.minCourse();
        final int expectedMinCourse = 1;
        assertEquals(expectedMinCourse, actualMinCourse);

        int actualMaxCourse = visitor.maxCourse();
        final int expectedMaxCourse = 5;
        assertEquals(expectedMaxCourse, actualMaxCourse);
    }
}