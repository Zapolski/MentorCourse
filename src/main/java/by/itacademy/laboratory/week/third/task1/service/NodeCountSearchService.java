package by.itacademy.laboratory.week.third.task1.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.Objects.nonNull;

public class NodeCountSearchService {

    public <T> int calculateCountOfNodes(TreeNode<T> node) {
        int result = 0;
        if (node != null) {
            result = 1 + calculateCountOfNodes(node.getLeft()) + calculateCountOfNodes(node.getRight());
        }

        return result;
    }

    public <T> int calculateCountOfNodesSimple(TreeNode<T> root) {
        int result = 0;
        if (nonNull(root)) {
            Deque<TreeNode<T>> deque = new ArrayDeque<>();
            deque.add(root);
            while (deque.peek() != null) {
                TreeNode<T> node = deque.poll();
                result++;
                if (nonNull(node.getLeft())) {
                    deque.add(node.getLeft());
                }
                if (nonNull(node.getRight())) {
                    deque.add(node.getRight());
                }
            }
        }

        return result;
    }
}
