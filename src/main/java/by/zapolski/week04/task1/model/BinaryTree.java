package by.zapolski.week04.task1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    public static class Node<T> implements TreeNode<T>{
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        @Override
        public Node<T> getLeftChild() {
            return leftChild;
        }

        @Override
        public Node<T> getRightChild() {
            return rightChild;
        }

        public Node(T value) {
            this.value = value;
        }

        @Override
        public T getValue() {
            return value;
        }
    }

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null) {
            root = node;
        } else {
            Node<T> current = root;
            while (true) {
                int cmp = value.compareTo(current.value);
                if (cmp < 0) {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        return;
                    } else {
                        current = current.leftChild;
                    }
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        return;
                    } else {
                        current = current.rightChild;
                    }
                }
            }
        }
    }

    public List<String> output() {
        return root != null ? output(root) : Collections.singletonList("Binary tree doesn't contain elements.");
    }

    private List<String> output(Node<T> element) {
        List<String> result = new ArrayList<>();
        addChildForPrint(result, element.rightChild);
        result.add(element.value.toString());
        addChildForPrint(result, element.leftChild);
        return result;
    }

    private void addChildForPrint(List<String> result, Node<T> rightChild) {
        if (rightChild != null) {
            List<String> temp = output(rightChild);
            temp.forEach(i -> result.add("    " + i));
        }
    }
}
