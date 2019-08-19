package by.zapolski.week03;

import by.zapolski.week03.task2.HighBinaryTreeService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HighBinaryTreeServiceTest extends BaseAbstractTest {

    private HighBinaryTreeService highBinaryTreeService = new HighBinaryTreeService();

    @Test
    public void heightOfBinaryTreeTest() {
        assertEquals(4, highBinaryTreeService.heightOfBinaryTree(binaryTree));
    }
}
