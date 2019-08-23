package by.zapolski.week04.task1.visitor;

import by.zapolski.week04.task1.model.TreeNodeDecorator;

import java.util.Collections;
import java.util.List;

public class StudentsGradesVisitor implements Visitor<List<String>> {
    @Override
    public List<String> visitNode(TreeNodeDecorator treeNodeDecorator) {
        return Collections.singletonList("[Меня поситил StudentsGradesVisitor]");
    }
}
