package by.zapolski.week04.model;

import by.zapolski.week04.task2.Visitor;

import java.util.List;

public class TreeNodeStudentDecorator implements TreeNode<Student> {

    private TreeNode<Student > treeNode;

    public TreeNodeStudentDecorator(TreeNode<Student> treeNode) {
        this.treeNode = treeNode;
    }

    @Override
    public TreeNode<Student> getLeftChild() {
        return treeNode.getLeftChild();
    }

    @Override
    public TreeNode<Student> getRightChild() {
        return treeNode.getRightChild();
    }

    @Override
    public Student getValue() {
        return treeNode.getValue();
    }

    @Override
    public void setLeftChild(TreeNode<Student> leftChild) {
        treeNode.setLeftChild(leftChild);
    }

    @Override
    public void setRightChild(TreeNode<Student> rightChild) {
        treeNode.setRightChild(rightChild);
    }

    @Override
    public void setValue(Student value) {
        treeNode.setValue(value);
    }

    public List<String> accept(Visitor visitor) {
        return visitor.doSomeThing();
    }

}