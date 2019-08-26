package by.zapolski.week04.task1.model;

import by.zapolski.week04.task1.visitor.StudentsCoursesVisitor;

public class Main {

    public static void main(String[] args) {

        BinaryTree<String> binaryTree = new BinaryTree<>();

        binaryTree.insert("F");
        binaryTree.insert("B");
        binaryTree.insert("A");
        binaryTree.insert("D");
        binaryTree.insert("C");
        binaryTree.insert("E");
        binaryTree.insert("G");
        binaryTree.insert("I");
        binaryTree.insert("H");

        binaryTree.output().forEach(System.out::println);

        TreeIterator<String> iter = new TreeIterator<>(binaryTree,BfsIterationStrategy.getInstance());
        iter.forEachRemaining(System.out::print);
        System.out.println();

        iter = new TreeIterator<>(binaryTree,DfsPreOrderIterationStrategy.getInstance());
        iter.forEachRemaining(System.out::print);


        BinaryTree<Student> studentTree = new BinaryTree<>();
        studentTree.insert(new Student());
        studentTree.insert(new Student());
        studentTree.insert(new Student());

        //передаелать, чтобы итераторы возвращадли ноду, а не значение
        TreeIterator<Student> studentTreeIterator = new TreeIterator<>(studentTree,DfsPreOrderIterationStrategy.getInstance());
        while (studentTreeIterator.hasNext()){
            TreeNode<Student> st = studentTreeIterator.next();
            TreeNodeStudentDecorator st2 = (TreeNodeStudentDecorator)studentTreeIterator.next();

            System.out.println( st.accept(new StudentsCoursesVisitor()) );

        }

    }

}
