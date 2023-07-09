package com.smallscholar.代码随想录.doubleNum;

import com.smallscholar.interviewClassic.LengthOfLongestSubstring;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 23:43
 * @describe 27. 移除元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;
        int count = 0;

        while (left <= right) {
            while (left <= right && nums[left] == val) {
                count += 1;
                swap(nums,left, right--);
            }
            left += 1;
        }

        return nums.length - count;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
