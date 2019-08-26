package by.zapolski.week04.task1.model;

import by.zapolski.week04.task1.visitor.Visitor;

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

    public List<String> accept(Visitor visitor) {
        return visitor.doSomeThing();
    }

}