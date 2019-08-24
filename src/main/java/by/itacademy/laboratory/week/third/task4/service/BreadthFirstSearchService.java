package by.itacademy.laboratory.week.third.task4.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Objects.nonNull;

public class BreadthFirstSearchService {

    public StringBuilder concatenateInBreadth(TreeNode<Character> node) {
        StringBuilder result = new StringBuilder();
        if (nonNull(node)) {
            Queue<TreeNode<Character>> queue = new LinkedList<>();
            queue.add(node);
            TreeNode<Character> currentNode;
            while ((currentNode = queue.poll()) != null) {
                result.append(currentNode.getValue());
                if (nonNull(currentNode.getLeft())) {
                    queue.add(currentNode.getLeft());
                }
                if (nonNull(currentNode.getRight())) {
                    queue.add(currentNode.getRight());
                }
            }
        }

        return result;
    }
}
