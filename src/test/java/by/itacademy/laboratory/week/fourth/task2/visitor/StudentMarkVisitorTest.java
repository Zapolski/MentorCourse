package by.itacademy.laboratory.week.fourth.task2.visitor;

import by.itacademy.laboratory.week.fourth.task1.domain.TreeSearchStrategy;
import by.itacademy.laboratory.week.fourth.task1.iterator.TreeIterator;
import by.itacademy.laboratory.week.fourth.task2.model.Student;
import by.itacademy.laboratory.week.fourth.task2.model.TreeVisitNode;
import by.itacademy.laboratory.week.fourth.task2.visitor.impl.StudentMarkVisitor;
import by.itacademy.laboratory.week.fourth.util.TreeNodeEntityUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentMarkVisitorTest {

    @Test
    public void checkStudentMarkVisitor() {
        TreeVisitNode<Student> root = TreeNodeEntityUtil.buildStudentVistiTree();
        TreeIterator<Student, TreeVisitNode<Student>> iterator = new TreeIterator<>(root, TreeSearchStrategy.DFS_PRE_ORDER);
        StudentMarkVisitor visitor = new StudentMarkVisitor();
        TreeVisitTraversal.traverseTree(iterator, visitor);

        double actualAverageMark = visitor.averageStudentMark();
        final double expectedAverageMark = 6.875;
        assertEquals(expectedAverageMark, actualAverageMark, 0.001);

        int actualTotalMark = visitor.totalStudentMark();
        final int expectedTotalMark = 55;
        assertEquals(expectedTotalMark, actualTotalMark);
    }
}