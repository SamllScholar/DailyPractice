package com.smallscholar.代码随想录.tree;

import com.smallscholar.normalPractice.may.Temp;
import com.smallscholar.programmingBasics.RomanToInt;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 20:47
 * @describe 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorBST {


    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (true) {
            if ((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)) {
                return root;
            } else if (root.val < p.val && root.val < q.val) {
                lowestCommonAncestor(root.right, p, q);
            } else if (root.val > p.val && root.val > q.val) {
                lowestCommonAncestor(root.left, p, q);
            } else {
                break;
            }
        }

        return null;
    }

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if ((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)) {
            ans = root;
            return true;
        }
        if (root.val < p.val && root.val < q.val) {
            lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        }
        return false;
    }

}
