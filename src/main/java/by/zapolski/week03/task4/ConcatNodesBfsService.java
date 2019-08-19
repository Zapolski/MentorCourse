package by.zapolski.week03.task4;

import by.zapolski.week03.model.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConcatNodesBfsService {

    // Breadth First Search (approach with loop)
    public String getConcatNodesString(BinaryTree tree) {
        BinaryTree.Node root = tree.getRoot();
        if (root == null) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();
            Queue<BinaryTree.Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                BinaryTree.Node currentNode = queue.poll();
                result.append(currentNode.getValue());
                if (currentNode.getLeftChild() != null) {
                    queue.offer(currentNode.getLeftChild());
                }
                if (currentNode.getRightChild() != null) {
                    queue.offer(currentNode.getRightChild());
                }
            }
            return result.toString();
        }
    }
}
