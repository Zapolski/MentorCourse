package by.zapolski.week04.task1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null) {
            root = node;
        } else {
            Node<T> current = root;
            while (true) {
                int cmp = value.compareTo(current.getValue());
                if (cmp < 0) {
                    if (current.getLeftChild() == null) {
                        current.getLeftChild() = node;
                        break;
                    } else {
                        current = current.getLeftChild();
                    }
                } else {
                    if (current.getRightChild() == null) {
                        current.getLeftChild() = node;
                        break;
                    } else {
                        current = current.getRightChild();
                    }
                }
            }
        }
    }

    public List<String> output() {
        return root != null ? output(root) : Collections.singletonList("Binary tree doesn't contain elements.");
    }

    private List<String> output(TreeNode<T> element) {
        List<String> result = new ArrayList<>();
        addChildForPrint(result, element.getRightChild());
        result.add(element.getValue().toString());
        addChildForPrint(result, element.getLeftChild());
        return result;
    }

    private void addChildForPrint(List<String> result, TreeNode<T> rightChild) {
        if (rightChild != null) {
            List<String> temp = output(rightChild);
            temp.forEach(i -> result.add("    " + i));
        }
    }

    public static class Node<T> implements TreeNode<T>{
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public Node<T> getLeftChild() {
            return leftChild;
        }

        @Override
        public Node<T> getRightChild() {
            return rightChild;
        }

        @Override
        public T getValue() {
            return value;
        }
    }
}
