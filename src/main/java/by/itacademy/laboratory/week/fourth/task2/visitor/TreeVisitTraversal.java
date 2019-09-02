package by.itacademy.laboratory.week.fourth.task2.visitor;

import by.itacademy.laboratory.week.fourth.task1.iterator.TreeIterator;
import by.itacademy.laboratory.week.fourth.task2.model.TreeVisitNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TreeVisitTraversal {

    public static <T> void traverseTree(TreeIterator<T, TreeVisitNode<T>> iterator, Visitor<T>... visitors) {
        while (iterator.hasNext()) {
            TreeVisitNode<T> nextNode = iterator.next();
            Arrays.stream(visitors).forEach(nextNode::accept);
        }
    }
}
