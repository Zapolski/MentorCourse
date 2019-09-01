package by.zapolski.week04.task1;

import by.zapolski.week04.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BfsIterationStrategy<T extends Comparable<T>> implements IterationStrategy<T> {

    private static BfsIterationStrategy instance;
    private Queue<TreeNode<T>> queue;

    public static <T extends Comparable<T>> BfsIterationStrategy<T> getInstance() {
        if (instance == null) {
            instance = new BfsIterationStrategy<T>();
        }
        return instance;
    }

    private BfsIterationStrategy() {
        queue = new LinkedList<>();
    }

    @Override
    public void init(TreeNode<T> node) {
        queue.offer(node);
    }

    @Override
    public TreeNode<T> getCurrent() {
        TreeNode<T> currentNode = queue.poll();
        if (currentNode != null) {
            if (currentNode.getLeftChild() != null) {
                queue.offer(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                queue.offer(currentNode.getRightChild());
            }
            return currentNode;
        } else {
            return null;
        }
    }
}
