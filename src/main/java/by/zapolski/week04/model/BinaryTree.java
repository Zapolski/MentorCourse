package by.zapolski.week04.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinaryTree() {
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(TreeNode<T> value) {
        this.root = insert(this.root, value);
    }

    private TreeNode<T> insert(TreeNode<T> currentRoot, TreeNode<T> value) {
        if (currentRoot == null) {
            return value;
        } else {
            if (currentRoot.getValue().compareTo(value.getValue()) < 0) {
                currentRoot.setLeftChild(insert(currentRoot.getLeftChild(), value));
            } else {
                currentRoot.setRightChild(insert(currentRoot.getRightChild(), value));
            }
        }
        return currentRoot;
    }

    public List<String> output() {
        return root != null ? output(root) : Collections.singletonList("Binary tree doesn't contain elements.");
    }

    private List<String> output(TreeNode<T> element) {
        List<String> result = new ArrayList<>();
        addChildForPrint(result, element.getLeftChild());
        result.add(element.getValue().toString());
        addChildForPrint(result, element.getRightChild());
        return result;
    }

    private void addChildForPrint(List<String> result, TreeNode<T> rightChild) {
        if (rightChild != null) {
            List<String> temp = output(rightChild);
            temp.forEach(i -> result.add("    " + i));
        }
    }

    public static class Node<T> implements TreeNode<T> {
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

        @Override
        public void setValue(T value) {
            this.value = value;
        }
    }
}
