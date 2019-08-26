package by.zapolski.week04.task1.visitor;

import by.zapolski.week04.task1.model.TreeNodeStudentDecorator;

import java.util.Collections;
import java.util.List;

public class StudentsCoursesVisitor implements Visitor {

    public List<String> report(TreeNodeStudentDecorator treeNodeStudentDecorator) {
        return treeNodeStudentDecorator.accept(this);
    }

    @Override
    public List<String> doSomeThing(){
        return Collections.singletonList("[Меня поситил StudentsCoursesVisitor]");
    }
}
