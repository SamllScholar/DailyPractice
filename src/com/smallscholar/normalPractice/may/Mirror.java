package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 20:47
 * @describe 二叉树的镜像
 * 要使用抽象的思维区想二叉树的题, 比如本次递归我需要什么东西, 那么我就直接进行获取, 而不需要了解递归具体的工作过程是什么样的
 */
public class Mirror {

    public TreeNode mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode left  = mirror(pRoot.left);
        TreeNode right = mirror(pRoot.right);
        pRoot.right = left;
        pRoot.left = right;

        return pRoot;
    }

}
