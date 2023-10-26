package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/25 20:51
 * @version 1.0
 * @describe lc: 面试题04.05:合法的二叉搜索树
 */
public class IsValidBST {

    int count = 0;
    int val;

    /**
     * 思路使用二叉搜索的特性, 中序遍历的结果一定是从小到大的, 所以可以在中序遍历的过程让当前的节点的值和原来的节点的值进行比较
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftBoolean = isValidBST(root.left);

        boolean curBoolean = true;
        if (count > 0) {
            if (root.val <= val) {
                curBoolean = false;
            }
        }
        count += 1;
        val = root.val;

        boolean rightBoolean = isValidBST(root.right);

        // 返回当前当前节点是否是二叉搜索树, 当前节点的左子树是否是二叉搜索数, 当前节点的右子树是否是二叉搜索数
        return leftBoolean && curBoolean && rightBoolean;
    }

}
