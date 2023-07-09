package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 9:46
 * @describe 在二叉树中找到两个节点的最近的公共祖先
 * 二叉树中最重要的是考虑好返回的条件, 比如当前的
 * 当前的节点有三种情况:
 * 左节点包含一个解, 右节点包含一个解, 那么当前节点就是最近的
 * 左节点或右节点包含一个解, 当前节点包含一个解
 * 左节点就是解或者右节点就是解(这种情况也需要更新val)
 */
public class LowestCommonAncestorUp {

    public static class Node{
        int val;
        boolean isAncestor;

        public Node(int val, boolean isAncestor) {
            this.val = val;
            this.isAncestor = isAncestor;
        }
    }


    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }

        return getAncestor(root, o1, o2).val;
    }

    public Node getAncestor(TreeNode root, int o1, int o2) {
        // 如果当前的节点是null, 直接返回null
        if (root == null) {
            return new Node(-1, false);
        }
        // 如果是当前的节点是子节点, 如果当前的节点是一个子节点返回true否则返回false
        if (root.left == null && root.right == null) {
            if (root.val == o1 || root.val == o2) {
                return new Node(-1, true);
            } else {
                return new Node(-1, false);
            }
        }
        // 找到左右节点的结果
        Node leftNode = getAncestor(root.left, o1, o2);
        Node rightNode = getAncestor(root.right, o1, o2);
        // 如果当前节点的左节点或者右节点已经是解了, 直接更新解
        int val = Math.max(leftNode.val, rightNode.val);
        // 如果左右节点各包含一个解
        // 如果左节点或右节点包含一个解, 当前的节点包含一个解需要更新节点的值
        val = ((leftNode.isAncestor && rightNode.isAncestor) || ((leftNode.isAncestor ||
                rightNode.isAncestor) && (root.val == o1 || root.val == o2))) ? root.val : val;
        // 如果左右节点不是解,但是当前节点是解那么直接进行返回
        boolean isAncestor = leftNode.isAncestor || rightNode.isAncestor || (root.val == o1 || root.val == o2);
        return new Node(val, isAncestor);
    }

}
