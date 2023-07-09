package com.smallscholar.代码随想录.tree;

import com.smallscholar.programmingBasics.RomanToInt;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 14:18
 * @describe 110. 平衡二叉树
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
