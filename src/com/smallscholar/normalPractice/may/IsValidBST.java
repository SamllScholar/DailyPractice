package com.smallscholar.normalPractice.may;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 21:10
 * @describe 判断一个二叉树是否是二叉搜索树
 */
public class IsValidBST {

    ArrayList<Integer> list = new ArrayList<>();

    public boolean isValidBST (TreeNode root) {
        preOrder(root);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        list.add(root.val);
        preOrder(root.right);
    }

}
