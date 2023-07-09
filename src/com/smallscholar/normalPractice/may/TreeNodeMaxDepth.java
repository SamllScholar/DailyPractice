package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 11:35
 * @describe 求二叉树的最大深度
 */
public class TreeNodeMaxDepth {

    int maxDepth = 0;

    public int maxDepth (TreeNode root) {
        getMaxDepth(root, 0);
        return maxDepth;
    }

    public void getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(depth, maxDepth);
            return;
        }

        getMaxDepth(root.left, depth + 1);
        getMaxDepth(root.right, depth + 1);
    }

}
