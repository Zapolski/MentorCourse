package by.itacademy.laboratory.week.third.task4.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;
import by.itacademy.laboratory.week.third.util.TreeNodeEntityUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BreadthFirstSearchServiceTest {

    private BreadthFirstSearchService breadthFirstSearchService = new BreadthFirstSearchService();

    @Test
    public void testBreadthConcatenation() {
        TreeNode<Character> root = TreeNodeEntityUtil.buildCharacterTree();

        StringBuilder actualResult = breadthFirstSearchService.concatenateInBreadth(root);
        final String expectedResult = "abfcdghe";
        assertEquals(expectedResult, actualResult.toString());
    }
}