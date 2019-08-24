package by.itacademy.laboratory.week.third.task2.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;

public class TreeDepthService {

    public <T> int findMaxDepth(TreeNode<T> root) {
        int result = 0;
        if (root != null) {
            result = 1;
            result = Math.max(result, 1 + findMaxDepth(root.getLeft()));
            result = Math.max(result, 1 + findMaxDepth(root.getRight()));
        }

        return result;
    }
}
