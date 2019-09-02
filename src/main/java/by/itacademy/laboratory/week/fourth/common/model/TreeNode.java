package by.itacademy.laboratory.week.fourth.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode<T> implements BinaryTreeNode<T>  {

    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }
}
