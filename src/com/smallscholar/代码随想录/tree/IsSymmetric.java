package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 13:00
 * @describe 101. 对称二叉树
 * 思路, 同时遍历这个树两次: 也就是同时遍历二叉树的两边
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

}
