package by.itacademy.laboratory.week.fourth.common.model;

public interface BinaryTreeNode<T> {

    T getValue();

    BinaryTreeNode<T> getLeft();

    BinaryTreeNode<T> getRight();

    void setValue(T value);

    void setLeft(BinaryTreeNode<T> treeNode);

    void setRight(BinaryTreeNode<T> treeNode);
}
