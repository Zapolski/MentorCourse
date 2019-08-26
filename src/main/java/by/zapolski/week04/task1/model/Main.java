package by.zapolski.week04.task1.model;

import by.zapolski.week04.task1.visitor.StudentsCoursesVisitor;
import by.zapolski.week04.task1.visitor.StudentsGradesVisitor;

public class Main {

    public static void main(String[] args) {

        BinaryTree<String> binaryTree = new BinaryTree<>();

        binaryTree.insert(new BinaryTree.Node<>("F"));
        binaryTree.insert(new BinaryTree.Node<>("B"));
        binaryTree.insert(new BinaryTree.Node<>("A"));
        binaryTree.insert(new BinaryTree.Node<>("D"));
        binaryTree.insert(new BinaryTree.Node<>("C"));
        binaryTree.insert(new BinaryTree.Node<>("E"));
        binaryTree.insert(new BinaryTree.Node<>("G"));
        binaryTree.insert(new BinaryTree.Node<>("I"));
        binaryTree.insert(new BinaryTree.Node<>("H"));

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
