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

    public void insert(TreeNode<T> value) {
        if (root == null) {
            root = value;
        } else {
            TreeNode<T> current = root;
            while (true) {
                int cmp = value.getValue().compareTo(current.getValue());
                if (cmp < 0) {
                    if (current.getLeftChild() == null) {
                        current.setLeftChild(value);
                        break;
                    } else {
                        current = current.getLeftChild();
                    }
                } else {
                    if (current.getRightChild() == null) {
                        current.setRightChild(value);
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
        private TreeNode<T> leftChild;
        private TreeNode<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public TreeNode<T> getLeftChild() {
            return leftChild;
        }

        @Override
        public TreeNode<T> getRightChild() {
            return rightChild;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public void setLeftChild(TreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        @Override
        public void setRightChild(TreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
