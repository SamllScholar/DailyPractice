package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 18:16
 * @describe 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {

    /**
     * 递归的思想, 找到根节点在数组中的位置的位置, 然后分别构造左右子树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
         return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, start, index - 1);
        root.right = build(nums, index + 1, end);
        return root;
    }

}
