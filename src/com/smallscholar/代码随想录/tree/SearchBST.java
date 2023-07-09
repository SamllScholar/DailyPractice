package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 18:46
 * @describe 700. 二叉搜索树中的搜索
 * 利用二叉搜索树的性质, 根节点的左子树的所有节点一定比根节点小, 根节点的右子树的所有节点的值一定比根节点大
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right,val);
        } else {
            return searchBST(root.left,val);
        }
    }

}
