package by.zapolski.week03.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree<T extends Comparable> {

    private static class Node<T> {
        private T value;
        private Node leftChild;
        private Node rightChild;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root;

    public void insert(T value){
        Node node = new Node(value);
        if(root==null){
            root = node;
        }else{
            Node current = root;
            while (true){

                int cmp = value.compareTo(current.value);

                if( cmp<0 ){
                    if(current.leftChild==null){
                        current.leftChild = node;
                        return;
                    }else {
                        current = current.leftChild;
                    }
                }else{
                    if(current.rightChild==null){
                        current.rightChild = node;
                        return;
                    }else{
                        current = current.rightChild;
                    }
                }

            }
        }
    }

    public List<String> output(){
        if(root!=null)
            return output(root);
        return Arrays.asList("Binary tree doesn't contain elements.");
    }

    private List<String> output(Node<T> element) {
        ArrayList<String> result = new ArrayList<>();

        if (element.rightChild != null) {
            List<String> temp = output(element.rightChild);
            for (int i = 0; i < temp.size(); i++) {
                result.add("    "+ temp.get(i));
            }
        }
        result.add(element.value.toString());
        if (element.leftChild != null) {
            List<String> temp = output(element.leftChild);
            for (int i = 0; i < temp.size(); i++) {
                result.add("    "+ temp.get(i));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.output().forEach(System.out::println);

        binaryTree.insert(8);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(14);
        binaryTree.insert(4);
        binaryTree.insert(7);
        binaryTree.insert(13);

        binaryTree.output().forEach(System.out::println);
    }
}
