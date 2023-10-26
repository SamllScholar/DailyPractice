package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/25 21:15
 * @version 1.0
 * @describe 面试题:04.04: 检查平衡性
 * 我这里是额外定义了一个数据结构来来同时保存子树的深度以及子树是否是平衡二叉树, 官方的方法是额外定义一个方法来求子树的深度
 */
public class IsBalanced {

    public class TreeStruct {
        int depth;
        boolean isBalanced;
    }

    public boolean isBalanced(TreeNode root) {
        return judge(root).isBalanced;
    }

    public TreeStruct judge(TreeNode root) {
        TreeStruct treeStruct = new TreeStruct();
        if (root == null) {
            treeStruct.isBalanced = true;
            treeStruct.depth = 0;
            return treeStruct;
        }

        TreeStruct leftJudge = judge(root.left);
        TreeStruct rightJudge = judge(root.right);

        treeStruct.depth = Math.max(leftJudge.depth, rightJudge.depth) + 1;
        treeStruct.isBalanced = leftJudge.isBalanced && rightJudge.isBalanced && Math.abs(leftJudge.depth - rightJudge.depth) <= 1;
        return treeStruct;
    }

}
