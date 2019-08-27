package by.zapolski.week04.task2;

import by.zapolski.week04.model.TreeNodeStudentDecorator;

public class StudentsCoursesVisitor implements Visitor {

    @Override
    public String doSomeThing(TreeNodeStudentDecorator treeNodeStudentDecorator){
        return "Я "+treeNodeStudentDecorator.getValue()+"[Меня поситил StudentsCoursesVisitor]";
    }
}
