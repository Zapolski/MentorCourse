package by.zapolski.week04.task1.model;

public interface IterationStrategy {

}


//
//    //Depth First Search (pre-order with recursion)
//    public String getConcatNodesStringPreOder(BinaryTree tree) {
//        if (tree.getRoot() == null) {
//            return "";
//        }
//        String result = tree.getRoot().getValue().toString();
//
//        result += getConcatNodesStringPreOder(new BinaryTree(tree.getRoot().getLeftChild()));
//        result += getConcatNodesStringPreOder(new BinaryTree(tree.getRoot().getRightChild()));
//
//        return result;
//    }
