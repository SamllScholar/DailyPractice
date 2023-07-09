package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 13:16
 * @describe 111. 二叉树的最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 && rightDepth == 0) {
            return 1;
        } else {
            leftDepth = leftDepth == 0 ? Integer.MAX_VALUE : leftDepth;
            rightDepth = rightDepth == 0 ? Integer.MAX_VALUE : rightDepth;

            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

}
