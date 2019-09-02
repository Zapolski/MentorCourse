package by.itacademy.laboratory.week.fourth.task1.iterator;

import by.itacademy.laboratory.week.fourth.common.model.BinaryTreeNode;
import by.itacademy.laboratory.week.fourth.task1.domain.TreeSearchable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TreeIterator<T, NODE extends BinaryTreeNode<T>> implements Iterator<NODE> {

    private Deque<BinaryTreeNode<T>> deque = new ArrayDeque<>();
    private TreeSearchable treeSearchable;

    public TreeIterator(NODE root, TreeSearchable treeSearchable) {
        this.deque.add(root);
        this.treeSearchable = treeSearchable;
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public NODE next() {
        return (NODE) treeSearchable.next(deque);
    }
}
