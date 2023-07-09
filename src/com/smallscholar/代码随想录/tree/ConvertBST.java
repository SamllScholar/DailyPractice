package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 22:19
 * @describe 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);



        return root;
    }

}
