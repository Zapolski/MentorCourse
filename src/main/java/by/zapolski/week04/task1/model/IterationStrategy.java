package by.zapolski.week04.task1.model;

public interface IterationStrategy<T> {
    void init(TreeNode<T> node);
    TreeNode<T> getCurrent();
}


