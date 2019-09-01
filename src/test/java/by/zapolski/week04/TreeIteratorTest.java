package by.zapolski.week04;

import by.zapolski.week04.model.BinaryTree;
import by.zapolski.week04.task1.BfsIterationStrategy;
import by.zapolski.week04.task1.DfsPreOrderIterationStrategy;
import by.zapolski.week04.task1.TreeIterator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeIteratorTest {

    private BinaryTree<String> binaryTree;

    @Before
    public void setUp(){
        binaryTree = new BinaryTree<>();
        binaryTree.insert(new BinaryTree.Node<>("F"));
        binaryTree.insert(new BinaryTree.Node<>("B"));
        binaryTree.insert(new BinaryTree.Node<>("A"));
        binaryTree.insert(new BinaryTree.Node<>("D"));
        binaryTree.insert(new BinaryTree.Node<>("C"));
        binaryTree.insert(new BinaryTree.Node<>("E"));
        binaryTree.insert(new BinaryTree.Node<>("G"));
        binaryTree.insert(new BinaryTree.Node<>("I"));
        binaryTree.insert(new BinaryTree.Node<>("H"));
    }

    @Test
    public void BfsIterationStrategyTest(){
        TreeIterator<String> iter = new TreeIterator<>(binaryTree, BfsIterationStrategy.getInstance());
        StringBuilder actual = new StringBuilder();
        while (iter.hasNext()) {
            actual.append(iter.next().getValue());
        }
        String expected = "FBGADICEH";
        assertEquals(expected,actual.toString());
    }


    @Test
    public void DfsPreOrderIterationStrategyTest(){
        TreeIterator<String> iter = new TreeIterator<>(binaryTree, DfsPreOrderIterationStrategy.getInstance());
        StringBuilder actual = new StringBuilder();
        while (iter.hasNext()) {
            actual.append(iter.next().getValue());
        }
        String expected = "FBADCEGIH";
        assertEquals(expected,actual.toString());
    }

}
