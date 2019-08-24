package by.itacademy.laboratory.week.third.task1.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;
import by.itacademy.laboratory.week.third.util.TreeNodeEntityUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeCountSearchServiceTest {

    private NodeCountSearchService nodeCountSearchService = new NodeCountSearchService();

    @Test
    public void shouldReturnValidCountOfNodes() {
        TreeNode<Integer> root = TreeNodeEntityUtil.buildDefaultTree();

        int actualCountOfNodes = nodeCountSearchService.calculateCountOfNodes(root);

        final int expectedCountOfNodes = 8;
        assertEquals(expectedCountOfNodes, actualCountOfNodes);
    }

    @Test
    public void shouldReturnValidCountOfNodesSimple() {
        TreeNode<Integer> root = TreeNodeEntityUtil.buildDefaultTree();

        int actualCountOfNodes = nodeCountSearchService.calculateCountOfNodesSimple(root);

        final int expectedCountOfNodes = 8;
        assertEquals(expectedCountOfNodes, actualCountOfNodes);
    }
}