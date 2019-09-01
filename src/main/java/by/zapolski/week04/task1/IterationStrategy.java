package by.zapolski.week04.task1;

import by.zapolski.week04.model.TreeNode;

public interface IterationStrategy<T> {
    void init(TreeNode<T> node);
    TreeNode<T> getCurrent();
}


