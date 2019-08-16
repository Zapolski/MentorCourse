package by.zapolski.week03;

import by.zapolski.week03.model.BinaryTree;
import org.junit.Before;


public abstract class BaseAbstractTest {

    BinaryTree<String> binaryTree = new BinaryTree<>();

    @Before
    public void before() {
        //F,B,A,D,C,E,G,I,H
        binaryTree.insert("F");
        binaryTree.insert("B");
        binaryTree.insert("A");
        binaryTree.insert("D");
        binaryTree.insert("C");
        binaryTree.insert("E");
        binaryTree.insert("G");
        binaryTree.insert("I");
        binaryTree.insert("H");
    }
}
