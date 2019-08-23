package by.zapolski.week04.task1.visitor;

import by.zapolski.week04.task1.model.TreeNodeDecorator;

public interface Visitor<T> {
    T visitNode(TreeNodeDecorator treeNodeDecorator);
}
