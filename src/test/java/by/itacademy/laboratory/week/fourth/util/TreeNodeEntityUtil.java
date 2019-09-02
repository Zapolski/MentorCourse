package by.itacademy.laboratory.week.fourth.util;

import by.itacademy.laboratory.week.fourth.common.model.TreeNode;
import by.itacademy.laboratory.week.fourth.task2.model.Student;
import by.itacademy.laboratory.week.fourth.task2.model.TreeVisitNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TreeNodeEntityUtil {

    public static TreeNode<Integer> buildDefaultTree() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.getLeft().setLeft(new TreeNode<>(3));
        root.getLeft().setRight(new TreeNode<>(4));
        root.getLeft().getRight().setRight(new TreeNode<>(5));

        root.setRight(new TreeNode<>(6));
        root.getRight().setLeft(new TreeNode<>(7));
        root.getRight().setRight(new TreeNode<>(8));

        return root;
    }

    public static TreeVisitNode<Student> buildStudentVistiTree() {
        TreeVisitNode<Student> root = buildVisitNode(new Student(9, 1));
        root.setLeft(buildVisitNode(new Student(5, 2)));
        root.getLeft().setLeft(buildVisitNode(new Student(4, 3)));
        root.getLeft().setRight(buildVisitNode(new Student(8, 3)));
        root.getLeft().getRight().setRight(buildVisitNode(new Student(7, 1)));

        root.setRight(buildVisitNode(new Student(6, 2)));
        root.getRight().setLeft(buildVisitNode(new Student(10, 5)));
        root.getRight().setRight(buildVisitNode(new Student(6, 2)));

        return root;
    }

    public static <T> TreeVisitNode<T> buildVisitNode(T object) {
        return new TreeVisitNode<>(new TreeNode<>(object));
    }
}
