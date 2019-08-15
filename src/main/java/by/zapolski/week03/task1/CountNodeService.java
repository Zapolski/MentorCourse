package by.zapolski.week03.task1;

import by.zapolski.week03.model.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodeService {

    // pre-order with loop
    public int getCountNodeLoopImpl (BinaryTree binaryTree){
        BinaryTree.Node root = binaryTree.getRoot();
        if (root==null){
            return 0;
        }else{
            int counter = 0;
            Queue<BinaryTree.Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                BinaryTree.Node currentNode = queue.poll();
                counter++;
                if (currentNode.getLeftChild()!=null){
                    queue.offer(currentNode.getLeftChild());
                }
                if (currentNode.getRightChild()!=null){
                    queue.offer(currentNode.getRightChild());
                }
            }
            return counter;
        }
    }

    //pre-order with recursion
    public int getCountNodeRecImpl (BinaryTree binaryTree) {
        int result = 1;
        if (binaryTree.getRoot()==null){
            return 0;
        }
        result += getCountNodeRecImpl(new BinaryTree(binaryTree.getRoot().getLeftChild()));
        result += getCountNodeRecImpl(new BinaryTree(binaryTree.getRoot().getRightChild()));

        return result;
    }

}
