package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 19:37
 * @describe 对称二叉树
 */
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return Symmetrical(pRoot.left, pRoot.right);
    }

    public boolean Symmetrical(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return Symmetrical(left.left, right.right) && Symmetrical(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

    }

}
