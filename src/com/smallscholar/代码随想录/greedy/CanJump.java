package com.smallscholar.代码随想录.greedy;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 16:45
 * @describe ...
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (i > dp[i - 1]) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] > n - 1) {
                return true;
            }
        }

        return true;
    }

}
