package com.smallscholar.代码随想录.tree;


/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 19:36
 * @describe 98. 验证二叉搜索树
 * 还有一个方法, 就是先进行一遍中序遍历, 然后判断中序遍历的结果是否是升序的, 如果是那么这个数就是搜索二叉树, 如果不是
 * 那么这个数就不是搜索二叉树
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }

        return dfs(root.left, min,root.val) && dfs(root.right, root.val, max);
    }

}
