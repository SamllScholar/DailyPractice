package com.smallscholar.代码随想录.tree;

import com.smallscholar.interviewClassic.Rotate;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 21:45
 * @describe 669. 修剪二叉搜索树
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root.left != null) {
            root.left = trimBST(root.left, low, high);
        }
        if (root.right != null) {
            root.right = trimBST(root.right, low, high);
        }

        if (root.val < low) {
            return root.right;
        } else if (root.val > high) {
            return root.left;
        } else {
            return root;
        }
    }

}
