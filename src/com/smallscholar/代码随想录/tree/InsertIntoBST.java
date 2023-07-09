package com.smallscholar.代码随想录.tree;

import org.omg.CORBA.IRObject;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 21:10
 * @describe 701. 二叉搜索树中的插入操作
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            }
        }

        return root;
    }

}
