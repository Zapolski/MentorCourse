package by.zapolski.week03.task3;

import by.zapolski.week03.model.BinaryTree;

public class ConcatNodesDfsService {

    //Depth First Search (pre-order with recursion)
    public String getConcatNodesStringPreOder(BinaryTree tree) {
        if (tree.getRoot() == null) {
            return "";
        }
        String result = tree.getRoot().getValue().toString();

        result += getConcatNodesStringPreOder(new BinaryTree(tree.getRoot().getLeftChild()));
        result += getConcatNodesStringPreOder(new BinaryTree(tree.getRoot().getRightChild()));

        return result;
    }

    //Depth First Search (in-order with recursion)
    public String getConcatNodesStringInOder(BinaryTree tree) {
        if (tree.getRoot() == null) {
            return "";
        }
        String result = getConcatNodesStringInOder(new BinaryTree(tree.getRoot().getLeftChild()));
        result += tree.getRoot().getValue().toString();
        result += getConcatNodesStringInOder(new BinaryTree(tree.getRoot().getRightChild()));
        return result;
    }

    //Depth First Search (post-order with recursion)
    public String getConcatNodesStringPostOder(BinaryTree tree) {
        if (tree.getRoot() == null) {
            return "";
        }
        String result = getConcatNodesStringPostOder(new BinaryTree(tree.getRoot().getLeftChild()));
        result += getConcatNodesStringPostOder(new BinaryTree(tree.getRoot().getRightChild()));
        result += tree.getRoot().getValue().toString();

        return result;
    }
}
