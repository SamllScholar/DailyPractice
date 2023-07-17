package com.smallscholar.代码随想录.greedy;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 15:38
 * @describe 53. 最大子数组和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int left = 0;
        int ans = Integer.MIN_VALUE;
        int max = 0;
        int index = 0;
        while (index < nums.length && nums[index] <= 0) {
            index += 1;
        }
        if (index >= nums.length) {
            for (int num : nums) {
                ans = Math.max(ans, num);
            }
        }
        for (int right = index; right < nums.length; right++) {
            max += nums[right];
            if (max < 0) {
                left = right;
                max = 0;
                continue;
            }

            ans = Math.max(ans, max);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int i = new MaxSubArray().maxSubArray(nums);
        System.out.println(i);
    }

}
