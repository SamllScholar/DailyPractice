package com.smallscholar.interviewClassic;

import com.smallscholar.normalPractice.may.RightView;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 21:35
 * @describe 经典面试第六题: 189. 轮转数组
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
