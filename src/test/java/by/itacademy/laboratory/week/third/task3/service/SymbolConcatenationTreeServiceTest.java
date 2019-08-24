package by.itacademy.laboratory.week.third.task3.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;
import by.itacademy.laboratory.week.third.util.TreeNodeEntityUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SymbolConcatenationTreeServiceTest {

    private SymbolConcatenationTreeService concatenationTreeService = new SymbolConcatenationTreeService();

    @Test
    public void testPreOrderConcatenation() {
        TreeNode<Character> root = TreeNodeEntityUtil.buildCharacterTree();

        StringBuilder actualValue = concatenationTreeService.concatenatePreOrder(root);
        final String expectedValue = "abcdefgh";
        assertEquals(expectedValue, actualValue.toString());
    }

    @Test
    public void testInOrderConcatenation() {
        TreeNode<Character> root = TreeNodeEntityUtil.buildCharacterTree();

        StringBuilder actualValue = concatenationTreeService.concatenateInOrder(root);
        final String expectedValue = "cbdeagfh";
        assertEquals(expectedValue, actualValue.toString());
    }

    @Test
    public void testPostOrderConcatenation() {
        TreeNode<Character> root = TreeNodeEntityUtil.buildCharacterTree();

        StringBuilder actualValue = concatenationTreeService.concatenatePostOrder(root);
        final String expectedValue = "cedbghfa";
        assertEquals(expectedValue, actualValue.toString());
    }
}