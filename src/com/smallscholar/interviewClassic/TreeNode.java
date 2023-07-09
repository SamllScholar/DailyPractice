package com.smallscholar.interviewClassic;

import sun.reflect.generics.tree.Tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 10:02
 * @describe ...
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
