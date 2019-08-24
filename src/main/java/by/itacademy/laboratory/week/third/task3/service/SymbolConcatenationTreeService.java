package by.itacademy.laboratory.week.third.task3.service;

import by.itacademy.laboratory.week.third.common.model.TreeNode;

import static java.util.Objects.nonNull;

public class SymbolConcatenationTreeService {

    public StringBuilder concatenatePreOrder(TreeNode<Character> node) {
        StringBuilder result = new StringBuilder();
        if (nonNull(node)) {
            result.append(node.getValue());
            result.append(concatenatePreOrder(node.getLeft()));
            result.append(concatenatePreOrder(node.getRight()));
        }

        return result;
    }

    public StringBuilder concatenateInOrder(TreeNode<Character> node) {
        StringBuilder result = new StringBuilder();
        if (nonNull(node)) {
            result.append(concatenateInOrder(node.getLeft()));
            result.append(node.getValue());
            result.append(concatenateInOrder(node.getRight()));
        }

        return result;
    }

    public StringBuilder concatenatePostOrder(TreeNode<Character> node) {
        StringBuilder result = new StringBuilder();
        if (nonNull(node)) {
            result.append(concatenatePostOrder(node.getLeft()));
            result.append(concatenatePostOrder(node.getRight()));
            result.append(node.getValue());
        }

        return result;
    }
}
