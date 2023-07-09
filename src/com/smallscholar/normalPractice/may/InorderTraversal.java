package com.smallscholar.normalPractice.may;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 9:56
 * @describe 二叉树的中序遍历
 */
public class InorderTraversal {

    ArrayList<Integer> list = new ArrayList<>();

    public int[] inorderTraversal (TreeNode root) {
        inorder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
