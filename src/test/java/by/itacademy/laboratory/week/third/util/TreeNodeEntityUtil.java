package by.itacademy.laboratory.week.third.util;

import by.itacademy.laboratory.week.third.common.model.TreeNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TreeNodeEntityUtil {

    public static TreeNode<Integer> buildDefaultTree() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.getLeft().setLeft(new TreeNode<>(3));
        root.getLeft().setRight(new TreeNode<>(4));
        root.getLeft().getRight().setRight(new TreeNode<>(5));

        root.setRight(new TreeNode<>(6));
        root.getRight().setLeft(new TreeNode<>(7));
        root.getRight().setRight(new TreeNode<>(8));

        return root;
    }

    public static TreeNode<Character> buildCharacterTree() {
        TreeNode<Character> root = new TreeNode<>('a');
        root.setLeft(new TreeNode<>('b'));
        root.getLeft().setLeft(new TreeNode<>('c'));
        root.getLeft().setRight(new TreeNode<>('d'));
        root.getLeft().getRight().setRight(new TreeNode<>('e'));

        root.setRight(new TreeNode<>('f'));
        root.getRight().setLeft(new TreeNode<>('g'));
        root.getRight().setRight(new TreeNode<>('h'));

        return root;
    }
}
