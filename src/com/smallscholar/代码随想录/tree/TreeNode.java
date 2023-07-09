package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 12:36
 * @describe 二叉树的数据结构
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
