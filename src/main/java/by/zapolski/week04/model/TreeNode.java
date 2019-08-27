package by.zapolski.week04.model;

public interface TreeNode<T> {
    TreeNode<T> getLeftChild();
    TreeNode<T> getRightChild();
    T getValue();

    void setLeftChild(TreeNode<T> leftChild);
    void setRightChild(TreeNode<T> rightChild);
    void setValue(T value);
}
