package by.zapolski.week04.task1.model;

public interface IterationStrategy {

}

//    // Breadth First Search (approach with loop)
//    public String getConcatNodesString(BinaryTree tree) {
//        BinaryTree.Node root = tree.getRoot();
//        if (root == null) {
//            return "";
//        } else {
//            StringBuilder result = new StringBuilder();
//            Queue<BinaryTree.Node> queue = new LinkedList<>();
//            queue.offer(root);
//            while (!queue.isEmpty()) {
//                BinaryTree.Node currentNode = queue.poll();
//                result.append(currentNode.getValue());
//                if (currentNode.getLeftChild() != null) {
//                    queue.offer(currentNode.getLeftChild());
//                }
//                if (currentNode.getRightChild() != null) {
//                    queue.offer(currentNode.getRightChild());
//                }
//            }
//            return result.toString();
//        }
//    }
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
