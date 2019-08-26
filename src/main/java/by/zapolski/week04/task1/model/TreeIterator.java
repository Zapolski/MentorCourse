package by.zapolski.week04.task1.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator<T extends Comparable<T>> implements Iterator<BinaryTree.Node<T>> {

    private IterationStrategy<T> iterationStrategy;
    private BinaryTree.Node<T> currentValue;

    public TreeIterator(BinaryTree<T> binaryTree, IterationStrategy<T> iterationStrategy) {
        this.iterationStrategy = iterationStrategy;
        this.iterationStrategy.init(binaryTree.getRoot());
        this.currentValue = iterationStrategy.getCurrent();
    }

    @Override
    public boolean hasNext() {
        return currentValue != null;
    }

    @Override
    public BinaryTree.Node<T> next() {
        if (currentValue==null) {
            throw new NoSuchElementException();
        }
        return iterationStrategy.getCurrent();
    }
}
