package by.zapolski.week03.task2;

import by.zapolski.week03.model.BinaryTree;

public class HighBinaryTreeService {

    public int heightOfBinaryTree(BinaryTree tree) {
        if (tree.getRoot() == null) {
            return 0;
        } else {
            return 1 + Math.max(heightOfBinaryTree(new BinaryTree(tree.getRoot().getLeftChild())),
                    heightOfBinaryTree(new BinaryTree(tree.getRoot().getRightChild())));
        }
    }
}
