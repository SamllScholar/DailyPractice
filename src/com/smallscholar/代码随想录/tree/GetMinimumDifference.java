package com.smallscholar.代码随想录.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 19:57
 * @describe 530. 二叉搜索树的最小绝对差
 * 根据二叉搜索树的性质, 最小的绝对差一定在中序遍历的节点的前后节点中产生, 只需要进行中序遍历, 然后保存一下前一个节点
 * 和当前的节点的值做一下比较, 就可以找到最小值
 */
public class GetMinimumDifference {

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        return min;
    }

    // 如果不是用list来完成这道题
    //  可以看下面的注释, 在使用中序遍历的时候, 保存一下前一个节点, 这样就可以进行两个节点的比较了
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        // 在这里使用一个pre变量, 保存一下前一个节点,
        // 如果pre != null ---> 前一个节点不为空, min = math.min(min, root.val - pre.val)
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int minimumDifference = new GetMinimumDifference().getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

}
