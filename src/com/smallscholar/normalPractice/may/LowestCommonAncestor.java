package com.smallscholar.normalPractice.may;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 9:27
 * @describe 找到两个节点的最近的公共祖先, 在搜索二叉树中, 所以这一题比较简单
 */
public class LowestCommonAncestor {



    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if ((p >= root.val && q <= root.val) || (p <= root.val && q >= root.val)) {
            return root.val;
        }
        if (p >= root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }

}
