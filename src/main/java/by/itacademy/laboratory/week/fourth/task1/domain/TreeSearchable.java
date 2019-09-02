package by.itacademy.laboratory.week.fourth.task1.domain;

import by.itacademy.laboratory.week.fourth.common.model.BinaryTreeNode;

import java.util.Deque;

public interface TreeSearchable {

    <T> BinaryTreeNode<T> next(Deque<BinaryTreeNode<T>> deque);
}
