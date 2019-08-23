package by.zapolski.week04.task1.visitor;

import by.zapolski.week04.task1.model.TreeNodeDecorator;

import java.util.Collections;
import java.util.List;

public class StudentsCoursesVisitor implements Visitor<List<String>> {
    @Override
    public List<String> visitNode(TreeNodeDecorator treeNodeDecorator) {
        return treeNodeDecorator.accept(this);
    }

    public List<String> doSomeThing(){
        return Collections.singletonList("[Меня поситил StudentsCoursesVisitor]");
    }
}
