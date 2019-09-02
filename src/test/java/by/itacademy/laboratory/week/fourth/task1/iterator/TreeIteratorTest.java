package by.itacademy.laboratory.week.fourth.task1.iterator;

import by.itacademy.laboratory.week.fourth.common.model.TreeNode;
import by.itacademy.laboratory.week.fourth.task1.domain.TreeSearchStrategy;
import by.itacademy.laboratory.week.fourth.util.TreeNodeEntityUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeIteratorTest {

    @Test
    public void checkBfsIterator() {
        TreeNode<Integer> root = TreeNodeEntityUtil.buildDefaultTree();
        TreeIterator<Integer, TreeNode<Integer>> iterator = new TreeIterator<>(root, TreeSearchStrategy.BFS);
        List<Integer> actualListNodes = new ArrayList<>();
        while (iterator.hasNext()) {
            actualListNodes.add(iterator.next().getValue());
        }
        List<Integer> expectedListNodes = Arrays.asList(1, 2, 6, 3, 4, 7, 8, 5);

        assertEquals(expectedListNodes, actualListNodes);
    }

    @Test
    public void checkDfsPreOrderIterator() {
        TreeNode<Integer> root = TreeNodeEntityUtil.buildDefaultTree();
        TreeIterator<Integer, TreeNode<Integer>> iterator = new TreeIterator<>(root, TreeSearchStrategy.DFS_PRE_ORDER);
        List<Integer> actualListNodes = new ArrayList<>();
        while (iterator.hasNext()) {
            actualListNodes.add(iterator.next().getValue());
        }
        List<Integer> expectedListNodes = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        assertEquals(expectedListNodes, actualListNodes);
    }
}