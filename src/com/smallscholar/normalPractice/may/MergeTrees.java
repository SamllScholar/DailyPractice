package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 20:25
 * @describe 合并两个二叉树
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        // 如果两个节点都为空, 那么当前的节点肯定就是空, 不用继续递归添加了
        if (t1 == null && t2 == null) return null;
        // 就是非空判断, 精髓就是非空判断
        TreeNode root = new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));
        root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return root;
    }
}
