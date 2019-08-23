package by.zapolski.week04.task1.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {

    private IterationStrategy<T> iterationStrategy;
    private T currentValue;

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
    public T next() {
        if (currentValue==null) {
            throw new NoSuchElementException();
        }
        T value = currentValue;
        currentValue = iterationStrategy.getCurrent();
        return value;
    }
}
