package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 13:26
 * @describe 222. 完全二叉树的节点个数
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int leftDepth = 0;
        int rightDepth = 0;

        while (left != null) {
            leftDepth += 1;
            left = left.left;
        }
        while (right != null) {
            rightDepth += 1;
            right = right.right;
        }

        if (rightDepth == leftDepth) {
            return (int) (Math.pow(2, rightDepth) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
