package by.itacademy.laboratory.week.third.task2.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;
import by.itacademy.laboratory.week.third.util.TreeNodeEntityUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeDepthServiceTest {

    private TreeDepthService treeDepthService = new TreeDepthService();

    @Test
    public void shouldCalculateMaxTreeDepth() {
        TreeNode<Integer> root = TreeNodeEntityUtil.buildDefaultTree();

        int actualMaxDepth = treeDepthService.findMaxDepth(root);

        final int expectedMaxDepth = 4;
        assertEquals(expectedMaxDepth, actualMaxDepth);
    }

}