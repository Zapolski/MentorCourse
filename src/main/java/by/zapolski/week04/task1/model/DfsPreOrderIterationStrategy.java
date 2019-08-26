package by.zapolski.week04.task1.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class DfsPreOrderIterationStrategy<T extends Comparable<T>> implements IterationStrategy<T> {

    private static DfsPreOrderIterationStrategy instance;
    private Deque<TreeNode<T>> deque;

    public static <T extends Comparable<T>> DfsPreOrderIterationStrategy<T> getInstance() {
        if (instance == null) {
            instance = new DfsPreOrderIterationStrategy<T>();
        }
        return instance;
    }

    private DfsPreOrderIterationStrategy() {
        deque = new ArrayDeque<>();
    }

    @Override
    public void init(TreeNode<T> node) {
        deque.push(node);
    }

    @Override
    public TreeNode<T> getCurrent() {
        TreeNode<T> currentNode = deque.poll();
        if (currentNode != null){
            if (currentNode.getRightChild() != null){
                deque.push(currentNode.getRightChild());
            }
            if (currentNode.getLeftChild() != null){
                deque.push(currentNode.getLeftChild());
            }
            return currentNode;
        } else {
            return null;
        }
    }
}
