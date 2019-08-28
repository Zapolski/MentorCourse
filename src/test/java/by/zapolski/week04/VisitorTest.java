package by.zapolski.week04;

import by.zapolski.week04.model.BinaryTree;
import by.zapolski.week04.model.Student;
import by.zapolski.week04.model.TreeNodeStudentDecorator;
import by.zapolski.week04.task1.DfsPreOrderIterationStrategy;
import by.zapolski.week04.task1.TreeIterator;
import by.zapolski.week04.task2.StudentsCoursesVisitor;
import by.zapolski.week04.task2.StudentsGradesVisitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    private BinaryTree<Student> studentTree;

    @Before
    public void setUp(){
        studentTree = new BinaryTree<>();
        studentTree.insert(new BinaryTree.Node<>(new Student("Alan","math",8f)));
        studentTree.insert(new BinaryTree.Node<>(new Student("Dana","bio",9f)));
        studentTree.insert(new BinaryTree.Node<>(new Student("Jon","med",5f)));
    }

    @Test
    public void StudentsCoursesVisitorTest(){
        TreeIterator<Student> studentTreeIterator = new TreeIterator<>(studentTree, DfsPreOrderIterationStrategy.getInstance());
        StringBuilder actual = new StringBuilder();
        while (studentTreeIterator.hasNext()) {
            TreeNodeStudentDecorator studentNode = new TreeNodeStudentDecorator(studentTreeIterator.next());
            actual.append(studentNode.accept(new StudentsCoursesVisitor())).append(";");
        }
        String expected = "math;bio;med;";
        assertEquals(expected,actual.toString());
    }

    @Test
    public void StudentsGradesVisitorTest(){
        TreeIterator<Student> studentTreeIterator = new TreeIterator<>(studentTree, DfsPreOrderIterationStrategy.getInstance());
        StringBuilder actual = new StringBuilder();
        while (studentTreeIterator.hasNext()) {
            TreeNodeStudentDecorator studentNode = new TreeNodeStudentDecorator(studentTreeIterator.next());
            actual.append(studentNode.accept(new StudentsGradesVisitor())).append(";");
        }
        String expected = "8.0;9.0;5.0;";
        assertEquals(expected,actual.toString());
    }

}
