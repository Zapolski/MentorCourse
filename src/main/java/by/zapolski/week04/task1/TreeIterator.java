package by.zapolski.week04.task1;

import by.zapolski.week04.model.BinaryTree;
import by.zapolski.week04.model.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator<T extends Comparable<T>> implements Iterator<TreeNode<T>> {

    private IterationStrategy<T> iterationStrategy;
    private TreeNode<T> currentValue;

    public TreeIterator(BinaryTree<T> binaryTree, IterationStrategy<T> iterationStrategy) {
        this.iterationStrategy = iterationStrategy;
        this.iterationStrategy.init(binaryTree.getRoot());
        this.currentValue = iterationStrategy.getCurrent();
    }

    @Override
    public boolean hasNext() {
        return this.currentValue != null;
    }

    @Override
    public TreeNode<T> next() {
        if (this.currentValue==null) {
            throw new NoSuchElementException();
        }
        TreeNode<T> temp = currentValue;
        this.currentValue = iterationStrategy.getCurrent();
        return temp;
    }
}
