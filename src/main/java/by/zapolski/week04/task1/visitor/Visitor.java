package by.zapolski.week04.task1.visitor;

import by.zapolski.week04.task1.model.TreeNodeDecorator;

import java.util.List;

public interface Visitor<T> {
    T visitNode(TreeNodeDecorator treeNodeDecorator);
    List<String> doSomeThing();
}
