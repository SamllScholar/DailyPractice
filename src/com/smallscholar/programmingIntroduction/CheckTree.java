package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 21:39
 * @describe 编程入门第四题: 2236. 判断根结点是否等于子结点之和
 */
public class CheckTree {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
