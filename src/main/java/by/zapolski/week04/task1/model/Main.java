package by.zapolski.week04.task1.model;

import java.util.Iterator;

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

        Iterator<String> iter = new TreeIterator<>(binaryTree,null);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

}
