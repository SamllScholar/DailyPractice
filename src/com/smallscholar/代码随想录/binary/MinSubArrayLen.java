package com.smallscholar.代码随想录.binary;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 11:36
 * @describe 209. 长度最小的子数组
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 :res;
    }
}
