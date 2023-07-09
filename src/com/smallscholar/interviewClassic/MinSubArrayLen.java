package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/4 10:12
 * @describe 面试经典第三十一题: 209. 长度最小的子数组
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            sum += nums[right];
            while (sum > target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
