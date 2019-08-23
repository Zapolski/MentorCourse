package by.zapolski.week04.task1.model;

import by.zapolski.week04.task1.visitor.Visitor;

import java.util.List;

public class TreeNodeDecorator implements TreeNode {

    protected TreeNode treeNode;

    public TreeNodeDecorator(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    @Override
    public TreeNode getLeftChild() {
        return treeNode.getLeftChild();
    }

    @Override
    public TreeNode getRightChild() {
        return treeNode.getRightChild();
    }

    @Override
    public Object getValue() {
        return treeNode.getValue();
    }

    public List<String> accept(Visitor visitor) {
        return visitor.doSomeThing();
    }

}