package by.zapolski.week04.task1.model;

public interface IterationStrategy<T extends Comparable<T>> {
    void init(BinaryTree.Node<T> node);
    T getCurrent();
}


