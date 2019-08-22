package by.zapolski.week04.task1.model;

import java.util.Iterator;

public class TreeIterator<T extends Comparable<T>> implements Iterator {

    BinaryTree<T> binaryTree;
    IterationStrategy iterationStrategy;

    BinaryTree.Node<T> currentNode;

    public TreeIterator(BinaryTree<T> binaryTree, IterationStrategy iterationStrategy) {
        this.binaryTree = binaryTree;
        this.iterationStrategy = iterationStrategy;
        this.currentNode = binaryTree.getRoot();
    }

    @Override
    public boolean hasNext() {
        return currentNode==null;
    }

    @Override
    public T next() {
        return null;
    }
}
