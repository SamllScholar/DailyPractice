package com.smallscholar.normalPractice.may;

import com.sun.prism.ReadbackRenderTarget;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 9:59
 * @describe 二叉树的后续遍历
 */
public class PostorderTraversal {

    ArrayList<Integer> list = new ArrayList<>();
    public int[] postorderTraversal (TreeNode root) {
        postOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

}
