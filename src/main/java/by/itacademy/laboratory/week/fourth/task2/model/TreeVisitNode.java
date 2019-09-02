package by.itacademy.laboratory.week.fourth.task2.model;

import by.itacademy.laboratory.week.fourth.common.model.BinaryTreeNode;
import by.itacademy.laboratory.week.fourth.task2.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TreeVisitNode<T> implements BinaryTreeNode<T> {

    private BinaryTreeNode<T> treeNode;

    public void accept(Visitor<T> visitor) {
        visitor.visit(treeNode.getValue());
    }

    @Override
    public T getValue() {
        return treeNode.getValue();
    }

    @Override
    public BinaryTreeNode<T> getLeft() {
        return treeNode.getLeft();
    }

    @Override
    public BinaryTreeNode<T> getRight() {
        return treeNode.getRight();
    }

    @Override
    public void setValue(T value) {
        this.treeNode.setValue(value);
    }

    @Override
    public void setLeft(BinaryTreeNode<T> treeNode) {
        this.treeNode.setLeft(treeNode);
    }

    @Override
    public void setRight(BinaryTreeNode<T> treeNode) {
        this.treeNode.setRight(treeNode);
    }
}
