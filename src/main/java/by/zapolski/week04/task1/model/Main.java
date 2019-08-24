package by.zapolski.week04.task1.model;

public class Main {

    public static void main(String[] args) {

        BinaryTree<String> binaryTree = new BinaryTree<>();

        binaryTree.insert("F");
        binaryTree.insert("B");
        binaryTree.insert("A");
        binaryTree.insert("D");
        binaryTree.insert("C");
        binaryTree.insert("E");
        binaryTree.insert("G");
        binaryTree.insert("I");
        binaryTree.insert("H");

        binaryTree.output().forEach(System.out::println);

        TreeIterator<String> iter = new TreeIterator<>(binaryTree,BfsIterationStrategy.getInstance());
        iter.forEachRemaining(System.out::print);
        System.out.println();

        iter = new TreeIterator<>(binaryTree,DfsPreOrderIterationStrategy.getInstance());
        iter.forEachRemaining(System.out::print);



        //передаелать, чтобы итераторы возвращадли ноду, а не значение
//        iter = new TreeIterator<>(binaryTree,DfsPreOrderIterationStrategy.getInstance());
//        while (iter.hasNext()){
//            //System.out.println(new StudentsCoursesVisitor().visitNode(iter.next()));
//            System.out.println((TreeNodeDecorator)iter.next()).accept(new StudentsCoursesVisitor()));
//
//        }

    }

}
