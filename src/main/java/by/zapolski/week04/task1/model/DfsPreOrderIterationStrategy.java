package by.zapolski.week04.task1.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class DfsPreOrderIterationStrategy<T extends Comparable<T>> implements IterationStrategy<T> {

    private static DfsPreOrderIterationStrategy instance;
    private Deque<BinaryTree.Node<T>> deque;

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
    public void init(BinaryTree.Node<T> node) {
        deque.offer(node);
    }

    @Override
    public T getCurrent() {
        BinaryTree.Node<T> currentNode = deque.poll();
        if (currentNode != null){
            if (currentNode.getLeftChild() != null){
                deque.offer(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null){
                deque.offer(currentNode.getRightChild());
            }
            return currentNode.getValue();
        } else {
            return null;
        }
    }
}

//    //Depth First Search (pre-order with recursion)
//    public String getConcatNodesStringPreOder(BinaryTree tree) {
//        if (tree.getRoot() == null) {
//            return "";
//        }
//        String result = tree.getRoot().getValue().toString();
//
//        result += getConcatNodesStringPreOder(new BinaryTree(tree.getRoot().getLeftChild()));
//        result += getConcatNodesStringPreOder(new BinaryTree(tree.getRoot().getRightChild()));
//
//        return result;
//    }
