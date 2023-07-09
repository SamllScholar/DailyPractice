package com.smallscholar.代码随想录.binary;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 11:00
 * @describe 27. 移除元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int right = nums.length - 1;
        int count = 0;

        for (int i = 0; i <= right; i++) {
            while (i <= right && nums[i] == val) {
                count += 1;
                swap(nums, i, right--);
            }
        }

        return nums.length - count;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
