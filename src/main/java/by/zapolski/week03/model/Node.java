package by.zapolski.week03.model;

public class Node<T extends  Comparable> {

    private T value;
    private Node leftChild;
    private Node rightChild;

    public Node(T value) {
        this.value = value;
    }
}