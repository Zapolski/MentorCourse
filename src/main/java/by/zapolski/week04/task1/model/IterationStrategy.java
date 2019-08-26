package by.zapolski.week04.task1.model;

public interface IterationStrategy<T> {
    void init(BinaryTree.Node<T> node);
    BinaryTree.Node<T> getCurrent();
}


