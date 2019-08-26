package by.zapolski.week04.task1.model;

public interface TreeNode<T> {
    TreeNode<T> getLeftChild();
    TreeNode<T> getRightChild();
    T getValue();

    void setLeftChild(TreeNode<T> leftChild);
    void setRightChild(TreeNode<T> rightChild);
}
