package com.smallscholar.代码随想录.tree;

import com.smallscholar.normalPractice.may.RightView;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 22:02
 * @describe 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, start, mid - 1);
        root.right = build(nums,mid + 1, end);

        return root;
    }

}
