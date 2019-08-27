package by.zapolski.week04;

import by.zapolski.week04.model.BinaryTree;
import by.zapolski.week04.model.Student;
import by.zapolski.week04.model.TreeNodeStudentDecorator;
import by.zapolski.week04.task1.BfsIterationStrategy;
import by.zapolski.week04.task1.DfsPreOrderIterationStrategy;
import by.zapolski.week04.task1.TreeIterator;
import by.zapolski.week04.task2.StudentsCoursesVisitor;
import by.zapolski.week04.task2.StudentsGradesVisitor;

public class Main {

    public static void main(String[] args) {

        BinaryTree<String> binaryTree = new BinaryTree<>(new BinaryTree.Node<>("F"));

//        binaryTree.insert(new BinaryTree.Node<>("F"));
//        binaryTree.insert(new BinaryTree.Node<>("B"));
//        binaryTree.insert(new BinaryTree.Node<>("A"));
//        binaryTree.insert(new BinaryTree.Node<>("D"));
//        binaryTree.insert(new BinaryTree.Node<>("C"));
//        binaryTree.insert(new BinaryTree.Node<>("E"));
//        binaryTree.insert(new BinaryTree.Node<>("G"));
//        binaryTree.insert(new BinaryTree.Node<>("I"));
//        binaryTree.insert(new BinaryTree.Node<>("H"));

        //binaryTree.add(new BinaryTree.Node<>("F"));
        binaryTree.add(new BinaryTree.Node<>("B"));
        binaryTree.add(new BinaryTree.Node<>("A"));
        binaryTree.add(new BinaryTree.Node<>("D"));
        binaryTree.add(new BinaryTree.Node<>("C"));
        binaryTree.add(new BinaryTree.Node<>("E"));
        binaryTree.add(new BinaryTree.Node<>("G"));
        binaryTree.add(new BinaryTree.Node<>("I"));
        binaryTree.add(new BinaryTree.Node<>("H"));

        binaryTree.output().forEach(System.out::println);

        TreeIterator<String> iter = new TreeIterator<>(binaryTree, BfsIterationStrategy.getInstance());
        System.out.print("BfsIterationStrategy: ");
        while (iter.hasNext()) {
            System.out.print(iter.next().getValue());
        }
        System.out.println();

        TreeIterator<String> iter2 = new TreeIterator<>(binaryTree, DfsPreOrderIterationStrategy.getInstance());
        System.out.print("DfsPreOrderIterationStrategy: ");
        while (iter2.hasNext()) {
            System.out.print(iter2.next().getValue());
        }
        System.out.println();

        BinaryTree<Student> studentTree = new BinaryTree<>();
        studentTree.insert(new BinaryTree.Node<>(new Student()));
        studentTree.insert(new BinaryTree.Node<>(new Student()));
        studentTree.insert(new BinaryTree.Node<>(new Student()));

        TreeIterator<Student> studentTreeIterator = new TreeIterator<>(studentTree, DfsPreOrderIterationStrategy.getInstance());
        while (studentTreeIterator.hasNext()) {

            TreeNodeStudentDecorator studentNode = new TreeNodeStudentDecorator(studentTreeIterator.next());

            System.out.println(studentNode.accept(new StudentsCoursesVisitor()));
            System.out.println(studentNode.accept(new StudentsGradesVisitor()));

        }
    }
}
