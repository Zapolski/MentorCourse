package by.itacademy.laboratory.week.fourth.task1.domain;

import by.itacademy.laboratory.week.fourth.common.model.BinaryTreeNode;

import java.util.Deque;

public enum TreeSearchStrategy implements TreeSearchable {

    DFS_PRE_ORDER {
        @Override
        public <T> BinaryTreeNode<T> next(Deque<BinaryTreeNode<T>> deque) {
            BinaryTreeNode<T> next = null;
            if (!deque.isEmpty()) {
                next = deque.pollLast();
                if (next.getRight() != null) {
                    deque.addLast(next.getRight());
                }
                if (next.getLeft() != null) {
                    deque.addLast(next.getLeft());
                }
            }

            return next;
        }
    },
    BFS {
        @Override
        public <T> BinaryTreeNode<T> next(Deque<BinaryTreeNode<T>> deque) {
            BinaryTreeNode<T> next = null;
            if (!deque.isEmpty()) {
                next = deque.pollFirst();
                if (next.getLeft() != null) {
                    deque.addLast(next.getLeft());
                }
                if (next.getRight() != null) {
                    deque.addLast(next.getRight());
                }
            }

            return next;
        }
    }
}
