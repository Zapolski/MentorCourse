package by.zapolski.week04.task1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree<T extends Comparable> {

    public static class Node<T> {
        private T value;
        private Node leftChild;
        private Node rightChild;

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public Node(T value) {
            this.value = value;
        }

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
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
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
        if (root != null)
            return output(root);
        return Arrays.asList("Binary tree doesn't contain elements.");
    }

    private List<String> output(Node<T> element) {
        ArrayList<String> result = new ArrayList<>();
        addChildForPrint(result, element.rightChild);
        result.add(element.value.toString());
        addChildForPrint(result, element.leftChild);
        return result;
    }

    private void addChildForPrint(ArrayList<String> result, Node rightChild) {
        if (rightChild != null) {
            List<String> temp = output(rightChild);
            temp.forEach(i -> result.add("    " + i));
        }
    }
}
