package by.zapolski.week04.task2;

import by.zapolski.week04.model.TreeNodeStudentDecorator;

import java.util.Collections;
import java.util.List;

public class StudentsGradesVisitor implements Visitor {

    public List<String> report(TreeNodeStudentDecorator treeNodeStudentDecorator) {
        return treeNodeStudentDecorator.accept(this);
    }

    @Override
    public List<String> doSomeThing() {
        return Collections.singletonList("[Меня поситил StudentsGradesVisitor]");
    }
}
