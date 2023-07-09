package com.smallscholar.代码随想录.tree;

import com.smallscholar.programmingBasics.RomanToInt;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 14:56
 * @describe 404. 左叶子之和
 */
public class SumOfLeftLeaves {


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root);

    }

    public int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}
